package ch06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch06.dto.User5DTO;
import ch06.service.User5Service;

@Controller
public class User5Controller {

	@Autowired
	private User5Service service;
	
	@GetMapping("/user5/register")
	public String register() {		
		return "/user5/register";
	}
	
	@PostMapping("/user5/register")
	public String register(User5DTO dto) {
		service.insertUser5(dto);
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/list")
	public String list(Model model) {	
		List<User5DTO> users = service.selectUser5s();
		model.addAttribute("users", users);	
		return "/user5/list";
	}
	
	@GetMapping("/user5/modify")
	public String modify(@RequestParam("uid") String uid, Model model) {
		
		User5DTO user = service.selectUser5(uid);
		model.addAttribute(user);
		
		return "/user5/modify";
	}
	
	@PostMapping("/user5/modify")
	public String modify(@ModelAttribute User5DTO dto) {
		service.updateUser5(dto);
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/delete")
	public String delete(String uid) {
		service.deleteUser5(uid);
		return "redirect:/user5/list";
	}
	
}