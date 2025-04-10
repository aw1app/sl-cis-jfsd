package com.sl.demo_spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.sl.controller"})
@EnableJpaRepositories(basePackages = {"com.sl.repositry"})
@SpringBootApplication
@EntityScan(basePackages = "com.sl.entity")
public class DemoSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRestApplication.class, args);
	}

}
