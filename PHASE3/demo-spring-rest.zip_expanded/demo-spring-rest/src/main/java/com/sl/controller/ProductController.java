package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.Product;
import com.sl.repositry.ProductRepositry;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepositry productRepositry;
	
	@GetMapping("/list")
	public List<Product> getAllProducts(){
		List<Product> listOfProducts = productRepositry.findAll();
		
		return listOfProducts;
	}
	

}
