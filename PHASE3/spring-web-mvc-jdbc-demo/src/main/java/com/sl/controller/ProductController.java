package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sl.dao.ProductDAO;
import com.sl.entity.Product;


@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;
	
	
	
	
	//List all products
	/*
	@GetMapping("/list-products")
	@ResponseBody
	public String getAllProducts() {
		
		List<Product> products = productDAO.getAllProducts();
		
		StringBuffer response = new StringBuffer("");
		
		for(Product p:products) {
			response.append(p.getName() + "<BR>");
		}
		return response.toString();
		
	}
	*/
	
	@GetMapping("/list-products")	
	public String getAllProducts(Model model) {
		
		List<Product> products = productDAO.getAllProducts();
		
		model.addAttribute("prods", products);
		
		return "list-products"; // resolves to list-products.jsp
		
	}
	
	

}
