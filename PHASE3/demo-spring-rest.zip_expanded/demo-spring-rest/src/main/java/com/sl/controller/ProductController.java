package com.sl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.Product;
import com.sl.repositry.ProductRepositry;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepositry productRepositry;
	
	// LIST ALL PRODUCTS
	@GetMapping("/list")
	public List<Product> getAllProducts(){
		List<Product> listOfProducts = productRepositry.findAll();
		
		return listOfProducts;
	}
	
	// DISPLAY SINGLE PRODUCT
	@GetMapping("/details/{id}")
	public Product getProduct(@PathVariable("id") int id){
		Optional<Product> optionalProduct = productRepositry.findById(id);

		Product p= null;
		if (optionalProduct.isPresent()) {
			p = optionalProduct.get();
		}
		return p;
	}
	
	// INSERT A NEW PRODUCT
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product){
		Product createdProduct = productRepositry.save(product);
		
		return createdProduct;
	}
	
	// DELETE A PRODUCT
	@GetMapping("/delete/{id}")
	public String addProduct(@PathVariable("id") int id){
		Optional<Product> optionalProduct = productRepositry.findById(id);

		if (optionalProduct.isPresent()) {
			productRepositry.deleteById(id);
			return "deleted";
		}else {
			return "not found";
		}
		
	}
	

}
