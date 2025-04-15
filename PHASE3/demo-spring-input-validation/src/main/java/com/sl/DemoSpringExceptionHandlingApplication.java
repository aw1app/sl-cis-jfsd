package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.sl.controller", "com.sl.exception"})
@EnableJpaRepositories(basePackages = {"com.sl.repositry"})
@EntityScan(basePackages = "com.sl.entity")
@SpringBootApplication
public class DemoSpringExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringExceptionHandlingApplication.class, args);
	}

}
