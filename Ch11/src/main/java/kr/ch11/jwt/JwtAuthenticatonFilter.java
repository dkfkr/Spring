package kr.ch11.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtAuthenticatonFilter extends OncePerRequestFilter {
	
	
	private final JwtProvider jwtProvider;
	
	private static final String AUTH_HEADER = "Authorization";
	private static final String TOKEN_PREFIX = "Bearer ";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		log.info("JwtAuthenticatonFilter...1");
		
		String header = request.getHeader(AUTH_HEADER);
		
		log.info("JwtAuthenticatonFilter...2 : " + header);
		
		String token = getTokenFromHeader(header);
		
		log.info("JwtAuthenticatonFilter...3 : " + token);
		
		if(token != null && jwtProvider.validateToken(token)) {
			log.info("JwtAuthenticatonFilter...4");
			// Security 인증처리
			Authentication authentication = jwtProvider.getAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	public String getTokenFromHeader(String header) {
		
		if(header != null && header.startsWith(TOKEN_PREFIX)) {
			return header.substring(TOKEN_PREFIX.length());
		}
		
		return null;
		
	}
	
}
