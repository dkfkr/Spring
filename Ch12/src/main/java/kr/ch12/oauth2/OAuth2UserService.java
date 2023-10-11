package kr.ch12.oauth2;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kr.ch12.entity.UserEntity;
import kr.ch12.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		String accessToken = userRequest.getAccessToken().getTokenValue();
		log.info("OAuth2UserService1 : " + accessToken);
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		log.info("OAuth2UserService2 : " + provider);

		OAuth2User oauth2User = super.loadUser(userRequest);
		log.info("OAuth2UserService3 : " + oauth2User);
	
		Map<String, Object> attributes = oauth2User.getAttributes();
		KakaoInfo kakaoInfo = new KakaoInfo(attributes);
		log.info("OAuth2UserService4 : " + kakaoInfo);
		
		// 회원가입 처리
		String id = kakaoInfo.getId();
		String email = kakaoInfo.getEamil();
		String nickname = kakaoInfo.getNickname();
		
		Optional<UserEntity> result = userRepository.findById(id);
		
		UserEntity user = null;
		
		if(result.isEmpty()) {
			// 최초 소셜 로그인시 동의 후 가입 
			user = UserEntity.builder()
										.uid(provider+"_"+id)
										.name(nickname)
										.nickname(nickname)
										.email(email)
										.provider(provider)
										.role("USER")
										.build();
			
			userRepository.save(user);
			
		}else {
			// 소셜가입 사용자 조회
			user = result.get();
			
		}
		
		return user;
	}
	
	 
	
}
