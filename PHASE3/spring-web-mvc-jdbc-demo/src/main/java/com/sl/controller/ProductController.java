package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.dao.ProductDAO;
import com.sl.entity.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	// List all products
	/*
	 * @GetMapping("/list-products")
	 * 
	 * @ResponseBody public String getAllProducts() {
	 * 
	 * List<Product> products = productDAO.getAllProducts();
	 * 
	 * StringBuffer response = new StringBuffer("");
	 * 
	 * for(Product p:products) { response.append(p.getName() + "<BR>"); } return
	 * response.toString();
	 * 
	 * }
	 */

	@GetMapping("/list-products")
	public String getAllProducts(Model model) {

		List<Product> products = productDAO.getAllProducts();

		model.addAttribute("prods", products);

		return "list-products"; // resolves to list-products.jsp

	}

	@PostMapping("/update-product-price")
	@ResponseBody
	public String updateProductPrice(@RequestParam("id") int id, @RequestParam("price") float price) {

		productDAO.updateProductPrice(id, price);

		return "Product with ID " + id + " price has been successfully update to " + price;
	}

}
