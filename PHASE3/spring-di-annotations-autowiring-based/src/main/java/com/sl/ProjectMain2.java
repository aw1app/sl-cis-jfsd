package com.sl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sl"})
public class ProjectMain2 {
	
	@Autowired Product p1;
	
	
	public static void main(String[] args) {		
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectMain2.class);
		
		ProjectMain2 project = context.getBean(ProjectMain2.class);
		
		System.out.println("Product p1's name is " + project.p1.getName());
		System.out.println("Product p1's desc is " + project.p1.getDesc());
		System.out.println("Product p1's price is " + project.p1.getPrice());


	}

}
