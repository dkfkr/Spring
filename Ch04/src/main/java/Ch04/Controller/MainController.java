package Ch04.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting() {
		return "greeting";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/annotation/param";
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "forward:/annotation/model";
	}
	
	
}
