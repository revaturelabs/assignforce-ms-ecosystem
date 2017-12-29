package com.assignforce.locationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class LocationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationMicroserviceApplication.class, args);
	}
}
