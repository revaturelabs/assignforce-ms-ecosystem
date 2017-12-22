package com.revature.curriculumms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AssignforceCurriculumMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceCurriculumMsApplication.class, args);
	}

	@RequestMapping("/test")
	public String testMsg(){
		return "test message";
	}
}
