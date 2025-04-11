package com.sl.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.sl.entity.Product;
import com.sl.exception.MyException;
import com.sl.repositry.ProductRepositry;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepositry productRepositry;
	
	@GetMapping("/list-products")
	public String listOfProducts(Model model) {

		List<Product> listOfProducts = productRepositry.findAll();

		model.addAttribute("listOfProducts", listOfProducts);
		
		// some conditions when we to throw our custom exception
		// these are handled in the global exception handler
		if(listOfProducts.isEmpty()) {
			throw new MyException("no products in th list!");
		}else if(listOfProducts.size() > 5) {
			throw new MyException("too many products (>5) !");
		}
		
//		 manually let's create a exception situation and observe how
//		 end user will see this in thier browser
		if(true)
		throw new RuntimeException("Some error happened");

		return "list-products"; // resolve list-products.jsp in WEB-INF/views
	}
	
	
	/*
	
	//Exception handling for above RuntimeException
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException( RuntimeException ex){
//		
//		Map<String, Object> error = new HashMap<>();
//        error.put("timestamp", LocalDateTime.now());
//        error.put("message", ex.getMessage());
//        error.put("status", HttpStatus.NOT_FOUND.value());
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(
				"<b>OOPs!!</b> something went wrong. Contact our CC <i>900123456</i>",
				HttpStatus.BAD_REQUEST
				);
		
	}
	
	*/


}
