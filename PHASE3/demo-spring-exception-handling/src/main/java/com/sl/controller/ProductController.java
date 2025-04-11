package com.sl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sl.entity.Product;
import com.sl.exception.MyException;
import com.sl.exception.ProductException;
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
	
	
	@GetMapping("/details/{id}")
	public String getProductDetails(Model model, @PathVariable("id") int id) throws ProductException{
		Optional<Product> optionalProduct = productRepositry.findById(id);

		Product p = null;
		if (optionalProduct.isPresent()) {
			p = optionalProduct.get();
			model.addAttribute("product", p);
			return "product-details"; //goes to product-details.jsp	
		}else {
			throw new ProductException("product with given id not found!");
		}	
		
	}
	


}
