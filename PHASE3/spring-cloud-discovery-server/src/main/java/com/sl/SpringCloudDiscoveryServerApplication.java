package com.sl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoveryServerApplication.class, args);
	}

}
