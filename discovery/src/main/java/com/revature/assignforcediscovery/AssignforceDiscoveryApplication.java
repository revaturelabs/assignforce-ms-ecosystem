package com.revature.assignforcediscovery;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AssignforceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceDiscoveryApplication.class, args);
	}
}
