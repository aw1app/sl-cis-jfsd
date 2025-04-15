package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.sl.entity.Product;

@Controller
public class ProductController {
	
	// Rest Client using RestTemplate
	@Autowired
	RestTemplate restTemplate;
	
	String restAPIServerBaseURL = "http://localhost:8080/products";
	
	
	@GetMapping("/list-products")
	public String getAllProducts(Model model) {
		
		ResponseEntity<Product[]> response = restTemplate.getForEntity(restAPIServerBaseURL + "/" +  "list", Product[].class);
		
		Product[] products = response.getBody();
		
		model.addAttribute("products", products);
		
		return "list-products"; // resolves webapp/WEB-INF/view/list-products.jsp
	}

}
