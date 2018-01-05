package com.revature.curriculumservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class CurriculumServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurriculumServiceApplication.class, args);
	}

	@RequestMapping("/test")
	public String testMsg(){
		return "test message";
	}
}
