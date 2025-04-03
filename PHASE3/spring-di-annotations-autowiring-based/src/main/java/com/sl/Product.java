package com.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product implements IProduct {

	String name;
	String desc;
	float price;

	
	public Product(@Value("iPhone") String name, @Value("Some Desc") String desc,
			@Value("99999") float price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
