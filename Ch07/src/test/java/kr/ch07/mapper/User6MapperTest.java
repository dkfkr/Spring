package kr.ch07.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.ch07.dto.User6DTO;
import kr.ch07.mapper.User6Mapper;
import kr.ch07.service.User6Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class User6MapperTest {

	@Autowired
	private User6Service service;
	
	
	public void insertUser6() {
		
		User6DTO user6 = User6DTO.builder()
				.uid("A606")
				.name("홍길동")
				.hp("010-1234-1001")
				.age(33)
				.build();
		
		service.insertUser6(user6);
		
		
	}
	
	public void selectUser6(String uid) {
		
		uid = "fg0120";
		
		service.selectUser6(uid);
	}
	
	@Test
	public void selectUser6s(){
		List<User6DTO> users = service.selectUser6s();
		
		for(User6DTO user : users) {
			log.info(user.toString());	
		}
		
	}
	
	public void updateUser6(User6DTO dto) {
		
		User6DTO user6 = User6DTO.builder()
				.uid("A606")
				.name("홍길동")
				.birth("1999-01-20")
				.gender("F")
				.age(33)
				.addr("대구 광역시")
				.hp("060-6234-6006")
				.build();
		
		service.updateUser6(user6);
	}
	
	public void deleteUser6(String uid) {
		
		uid = "fg0120";
		
		service.deleteUser6(uid);
		
	}
	
}
