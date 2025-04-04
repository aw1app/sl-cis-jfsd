package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/home1")	
	public String home1() {
		return "home"; // resolved to home.jsp in the WEB-INF/views folder
	}

	@GetMapping("/home2")
	@ResponseBody
	public String home2() {
		return "Home sweet home";
	}

}
