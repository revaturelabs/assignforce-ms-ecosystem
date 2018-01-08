package com.assignforce.locationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.assignforce.locationmicroservice", "com.revature.assignforcecommon.security"}, exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableCircuitBreaker
@EnableDiscoveryClient
public class LocationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationMicroserviceApplication.class, args);
	}
}
