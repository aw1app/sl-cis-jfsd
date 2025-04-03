package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		IProduct p1 =  context.getBean("product1", IProduct.class);
		
		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());


	}

}
