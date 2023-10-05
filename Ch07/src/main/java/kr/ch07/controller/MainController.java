package kr.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import kr.ch07.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
		String str1 = "스프링부트";
		String str2 = "타임리프";
		
		User1DTO user1 = new User1DTO("A101", "김유신", "010-1234-1002", 23);
		
		User1DTO user2 = new User1DTO();
		user2.setUid("A102");
		user2.setName("김춘추");
		user2.setHp("010-1234-1002");
		user2.setAge(25);
		
		User1DTO user3 = User1DTO.builder()
						.uid("A103")
						.name("장보고")
						.hp("010-1234-1234")
						.age(23)
						.build();
		
		User1DTO user4 = null;
		
		// 리스트 생성
		List<User1DTO> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(new User1DTO("A104", "김한별", "010-1234-1004", 23));
		users.add(new User1DTO("A105", "박한조", "010-1234-1005", 26));
		users.add(new User1DTO("A106", "강감찬", "010-1234-1006", 28));
		users.add(new User1DTO("A107", "이순신", "010-1234-1007", 22));
		users.add(new User1DTO("A108", "김고은", "010-1234-1008", 26));
		users.add(new User1DTO("A109", "김민수", "010-1234-1009", 29));
		users.add(new User1DTO("A110", "김창섭", "010-1234-1010", 30));
		
		model.addAttribute("str1", str1);
		model.addAttribute("str2", str2);
		model.addAttribute("user1", user1);
		model.addAttribute("user2", user2);
		model.addAttribute("user3", user3);
		model.addAttribute("user4", user4);
		model.addAttribute("users", users);
		
		log.debug("str1", str1.toString());
		log.debug("str2", str2.toString());
		log.debug("user1", user1.toString());
		log.debug("user2", user2.toString());
		log.debug("user3", user3.toString());
		log.debug("users", users.toString());
		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
	@GetMapping("/layout")
	public String layout() {
		return "/layout";
	}
	
}
