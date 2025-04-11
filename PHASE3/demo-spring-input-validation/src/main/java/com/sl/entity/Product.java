package com.sl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotBlank(message = "Product name must not be null")
	@Pattern(regexp = "^.{3,8}$", message = "Product name must be between 3 and 8 characters long")
	//@Size(min = 3, max=8, message = "Product name must atleast have 3 characters")	
	//@Min(value= 3 , message = "Product name must atleast have 3 characters")
	String name;
	
	@Min(value=10, message = "Product price must atleast have 2 digits")
	@Column(name="price")
	float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}