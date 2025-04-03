package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sl"})
public class ProjectMain {

	public static void main(String[] args) {		
	

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectMain.class);
		
		IProduct p1 =  context.getBean(Product.class);
		
		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());


	}

}
