package kr.ch10.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch10.dto.User6DTO;
import kr.ch10.service.user.User6MapperService;

@Controller
public class User6MapperController {
	
	@Autowired
	private User6MapperService service;
	
	@GetMapping("/user6/list")
	public String list(Model model) {
	    List<User6DTO> users = service.selectUser6s();
	    model.addAttribute("users", users);
	    return "user6/list";
	}
	
	@GetMapping("/user6/register")
	public String register() {
	    return "user6/register"; 
	}
	
	@PostMapping("/user6/register")
	public String register(User6DTO dto) {
	    service.insertUser6(dto);
	    return "redirect:/user6/list";
	}
	
	@GetMapping("/user6/modify")
	public String modify(Model model, String id) {
		
		User6DTO user = service.selectUser6(id);
		model.addAttribute("user",user);
		
		return "/user6/modify";
	}
	
	@PostMapping("/user6/modify")
	public String modify(User6DTO dto) {
		
		service.updateUser6(dto);
		
		return "redirect:/user6/list";
	}
	
	@GetMapping("/user6/delete")
	public String delete(String id) {
		
		service.deleteUser6(id);
		
		return "redirect:/user6/list";
	}
	
}
