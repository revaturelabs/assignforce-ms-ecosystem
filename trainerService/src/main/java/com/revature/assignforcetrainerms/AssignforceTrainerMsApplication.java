package com.revature.assignforcetrainerms;

import com.revature.assignforcetrainerms.dao.TrainerRepository;
import com.revature.assignforcetrainerms.domain.Trainer;
import com.revature.assignforcetrainerms.service.TrainerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class AssignforceTrainerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceTrainerMsApplication.class, args);
	}

	@Autowired
	TrainerDaoService service;


	@Bean
	public CommandLineRunner demo(TrainerRepository dao) {
		service.saveItem(new Trainer());
		return (args) -> {
			// save a couple of customers
			List<Trainer> trainers = service.getAllItems();
			for (Trainer post : trainers) {
				System.out.println(post.toString());
			}
		};
	}
}
