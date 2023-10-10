package kr.ch11.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.ch11.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -7339743802652072591L;
	
	private UserEntity user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 가지는 권한 목록
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// 계정이 가지는 비밀번호
		return user.getPass();
	}

	@Override
	public String getUsername() {
		// 계정이 가지는 아이디
		return user.getUid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부 (true= 만료 x , false= 만료 O)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금 여부 (true= 잠금 x , false= 잠금 O)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 계정 비밀번호 만료 여부 (true= 만료 x , false= 만료 O)
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 활성화 여부 (true= 활성화 , false= 비활성화)
		return true;
	}
	
}
