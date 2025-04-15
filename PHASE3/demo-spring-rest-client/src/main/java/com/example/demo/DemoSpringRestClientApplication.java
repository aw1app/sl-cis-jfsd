package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.sl.controller", "com.sl.config"})
@SpringBootApplication
public class DemoSpringRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRestClientApplication.class, args);
	}

}
