package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/home")	
	public String home() {
		
		return "home"; // will resolve as home.jsp
		
	}
	
	
	@GetMapping("/home1")
	@ResponseBody
	public String home1() {
		
		return "home is sweet"; 
		
	}

}
