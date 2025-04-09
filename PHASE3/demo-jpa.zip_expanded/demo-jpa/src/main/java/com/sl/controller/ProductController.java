package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.entity.Product;
import com.sl.repositry.ProductRepositry;


@Controller
public class ProductController {

	@Autowired
	ProductRepositry productRepositry;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Test Succesful!";
	}

	@GetMapping("/list-products")
	public String listOfProducts(Model model) {

		List<Product> listOfProducts = productRepositry.findAll();

		model.addAttribute("listOfProducts", listOfProducts);

		return "list-products"; // resolve list-products.jsp in WEB-INF/views
	}

}
