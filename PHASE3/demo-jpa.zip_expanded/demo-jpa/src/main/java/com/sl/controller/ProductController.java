package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Test Succesful!";
	}

}
