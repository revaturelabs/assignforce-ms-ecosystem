package com.revature.assignforcebatchms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class AssignforceBatchMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceBatchMsApplication.class, args);
	}
}
