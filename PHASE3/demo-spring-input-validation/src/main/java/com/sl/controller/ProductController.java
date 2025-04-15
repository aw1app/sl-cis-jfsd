package com.sl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sl.entity.Product;
import com.sl.exception.ProductException;
import com.sl.repositry.ProductRepositry;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	ProductRepositry productRepositry;

	@GetMapping("/list-products")
	public String listOfProducts(Model model) {

		List<Product> listOfProducts = productRepositry.findAll();

		model.addAttribute("listOfProducts", listOfProducts);

		return "list-products"; // resolve list-products.jsp in WEB-INF/views
	}

	// ADD PRODUCT START
	@GetMapping("/add-product")
	public String showAddProductForm(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "add-product-form";
	}

	@PostMapping("/add-product")
	public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {	
		
		if (bindingResult.hasErrors()) {		
	        
	        model.addAttribute("product", product); 
	        model.addAttribute("errors", bindingResult);	
	        
			return "add-product-form"; 
		}

		productRepositry.save(product);

		return "redirect:/list-products";
	}
	// ADD PRODUCT END

	@GetMapping("/details/{id}")
	public String getProductDetails(Model model, @PathVariable("id") int id) throws ProductException {
		Optional<Product> optionalProduct = productRepositry.findById(id);

		Product p = null;
		if (optionalProduct.isPresent()) {
			p = optionalProduct.get();
			model.addAttribute("product", p);
			return "product-details"; // goes to product-details.jsp
		} else {
			throw new ProductException("product with given id not found!");
		}

	}

}
