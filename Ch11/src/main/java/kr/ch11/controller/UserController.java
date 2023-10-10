package kr.ch11.controller;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {
	
	
	private final AuthenticationManager atAuthenticationManager;
	private final JwtProvider jwtProvider;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserRequestDTO dto) {
	
		try {
			
			//loadUserByUsername이게 실행 됨
			UsernamePasswordAuthenticationToken authenticationToken
				= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
			
			Authentication authentication = atAuthenticationManager.authenticate(authenticationToken);
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			UserEntity user = userDetails.getUser();
			
			// JWT 토큰 발행
			String accessToken = jwtProvider.createToken(user, 1); // 1일
			String refreshToken = jwtProvider.createToken(user, 7);// 7일
			
			Map<String, String> resultMap = Map.of( "grantType", "Bearer",
													"accessToken", accessToken,
													"refreshToken", refreshToken);
			
			return resultMap;
			
		} catch (Exception e) {
			Map<String, String> resultMap = Map.of( "grantType", "None",
													"message", e.getMessage());

			return resultMap;
		}
		
	}
	
	
	
}
