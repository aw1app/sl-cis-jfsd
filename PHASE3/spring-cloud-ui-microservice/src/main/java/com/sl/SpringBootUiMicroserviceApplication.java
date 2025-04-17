package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.sl.controller", "com.sl.config"})
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootUiMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUiMicroserviceApplication.class, args);
	}

}
