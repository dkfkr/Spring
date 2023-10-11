package kr.ch12.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
@Entity
public class UserEntity implements OAuth2User {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private String role;
	private String zip;
	private String addr1;
	private String addr2;
	private String regip;	
	private int age;
	
	@CreationTimestamp
	private LocalDateTime regDate;
	@CreationTimestamp
	private LocalDateTime leaveDate;
	
	private String provider;
	private String nickname;
	private String email;
	
	@Override
	public Map<String, Object> getAttributes() {
		
		return null;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}
	
	
}
