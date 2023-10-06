package kr.ch10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ch10.entity.User5Entity;
import kr.ch10.service.User5Service;

@RestController
public class User5Controller {

	@Autowired
	private User5Service service;
	
	@GetMapping("/user5")
	public List<User5Entity> list() {
		List<User5Entity> user5s = service.selectUser5s();
		return user5s;
	}
	
	@GetMapping("/user5/{id}")
	public User5Entity user5(@PathVariable("id") String id) {
		return service.selectUser5(id);
	}
	
	@PostMapping("/user5")
	public void register(User5Entity user5) {
		service.insertUser5(user5);
	}
	
	@PutMapping("/user5")
	public void modify(User5Entity user5) {
		service.updateUser5(user5);
	}
	
	@DeleteMapping("/user5/{id}")
	public void delete(@PathVariable("id") String id) {
		service.deleteUser5(id);
	}
}