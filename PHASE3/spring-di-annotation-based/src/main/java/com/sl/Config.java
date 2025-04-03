package com.sl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean(name = "product1")
	public Product createProduct() {
		
		Product p = new Product("Dell Laptop", "High value laptop for Students",50000.0f);
		
		return p;		
	}
	
	
	@Bean(name = "product2")
	public Product createProduct2() {
		
		Product p = new Product("HP Laptop", "High Gaming laptop for Professors",150000.0f);
		
		return p;		
	}


}
