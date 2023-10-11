package kr.ch12.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

}
