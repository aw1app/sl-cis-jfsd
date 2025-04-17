package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.sl.repositry")
@ComponentScan(basePackages = "com.sl.controller")
@EntityScan(basePackages = "com.sl.entity")
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootUserProfileMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserProfileMicroserviceApplication.class, args);
	}

}
