package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch10.entity.User6Entity;
import kr.ch10.service.User6Service;

@RestController
public class User6Controller {

	@Autowired
	private User6Service service;
	
	@GetMapping("/user6")
	public List<User6Entity> list() {
		List<User6Entity> user6s = service.selectUser6s();
		return user6s;
	}
	
	@GetMapping("/user6/{seq}")
	public User6Entity user6(@PathVariable("seq") int seq) {
		return service.selectUser6(seq);
	}
	
	@PostMapping("/user6")
	public void register(User6Entity user6) {
		service.insertUser6(user6);
	}
	
	@PutMapping("/user6")
	public void modify(User6Entity user6) {
		service.updateUser6(user6);
	}
	
	@DeleteMapping("/user6/{seq}")
	public void delete(@PathVariable("seq") int seq) {
		service.deleteUser6(seq);
	}
}