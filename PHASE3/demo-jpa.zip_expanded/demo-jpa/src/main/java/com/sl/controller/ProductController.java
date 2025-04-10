package com.sl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// ADD PRODUCT START
	@GetMapping("/add-product")
	public String showAddProductForm(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "add-product-form";
	}

	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute("product") Product product) {
		productRepositry.save(product);

		return "redirect:/list-products";
	}
	// ADD PRODUCT END

	// EDIT PRODUCT START
	@GetMapping("/edit-product")
	public String showEditProductForm(Model model, @RequestParam("id") int id) {
		Optional<Product> optionalProduct = productRepositry.findById(id);

		Product p = null;
		if (optionalProduct.isPresent()) {
			p = optionalProduct.get();
		}

		model.addAttribute("product", p);
		return "edit-product-form";
	}

	@PostMapping("/edit-product")
	public String saveEditedProduct(@ModelAttribute("product") Product product) {
		productRepositry.save(product);

		return "redirect:/list-products";
	}

	// EDIT PRODUCT END

	// DELETE PRODUCT
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") int id) {
		productRepositry.deleteById(id);

		return "redirect:/list-products";
	}

	// ADVANCED mapping
	@PostMapping("/find-by-name")
	public String getAllProductsByName(Model model, @RequestParam("name") String name) {
		List<Product> listOfProducts = productRepositry.findByName(name);

		model.addAttribute("listOfProducts", listOfProducts);

		return "list-products"; // resolve to list-products.jsp in WEB-INF/views

	}

}
