package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.sl.entity.Product;

@Controller
public class ProductController {

	// Rest Client using RestTemplate
	@Autowired
	RestTemplate restTemplate;

	String productMicroserviceBaseURL = "http://product-microservice/products";

	@GetMapping("/list-products")
	public String getAllProducts(Model model) {

		ResponseEntity<Product[]> response = restTemplate.getForEntity(productMicroserviceBaseURL + "/list",
				Product[].class);

		Product[] products = response.getBody();

		model.addAttribute("products", products);

		return "list-products"; // resolves webapp/WEB-INF/view/list-products.jsp
	}
	
	// ADD PRODUCT START
	@GetMapping("/add-product")
	public String showAddProductForm(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "add-product-form";
	}

	@PostMapping("/add-product")
	public String addProduct(Product product) {

		restTemplate.postForEntity(productMicroserviceBaseURL + "/add", product, Product.class);

		return "redirect:/list-products";
	}
	// ADD PRODUCT END

}