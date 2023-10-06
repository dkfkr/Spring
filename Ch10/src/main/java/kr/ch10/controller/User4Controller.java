package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch10.entity.User4Entity;
import kr.ch10.service.User4Service;

@RestController
public class User4Controller {

	@Autowired
	private User4Service service;
	
	@GetMapping("/user4")
	public List<User4Entity> list() {
		List<User4Entity> user4s = service.selectUser4s();
		return user4s;
	}
	
	@GetMapping("/user4/{id}")
	public User4Entity user4(@PathVariable("id") String id) {
		return service.selectUser4(id);
	}
	
	@PostMapping("/user4")
	public void register(User4Entity user4) {
		service.insertUser4(user4);
	}
	
	@PutMapping("/user4")
	public void modify(User4Entity user4) {
		service.updateUser4(user4);
	}
	
	@DeleteMapping("/user4/{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteUser4(id);
	}
}