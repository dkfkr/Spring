package kr.ch11.jwt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import kr.ch11.entity.UserEntity;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Component
public class JwtProvider {

    private String issuer;
    private SecretKey secretKey;

    public JwtProvider(@Value("${jwt.issuer}") String issuer, @Value("${jwt.secret}") String secret) {

        this.issuer = issuer;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());

    }

    public String createToken(UserEntity user, int days) {

        // 발급일, 만료일 지정
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime() + Duration.ofDays(days).toMillis());

        // 클래임 생성
        Claims claims = Jwts.claims();
        claims.put("uid", user.getUid());
        claims.put("role", user.getRole());

        // 토큰 생성 및 반환
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setIssuer(issuer)
                .setIssuedAt(issuedDate)
                .setExpiration(expireDate)
                .addClaims(claims)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public Authentication getAuthentication(String token) {

        Claims claims = getClaims(token);
        String uid = (String) claims.get("uid");
        String role = (String) claims.get("role");

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        User principal = new User(uid, "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);

    }

    public boolean validateToken(String token) {

        try {

            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (Exception e) {
            log.debug("JWT 토큰 유효성 검사 실패: " + e.getMessage());
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
}

