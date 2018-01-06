package com.revature.assignforce.settingService;

import com.revature.assignforce.settingService.config.SpringApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EnableMongoRepositories(basePackages = "com.revature.assignforce.settingService")
@SpringBootApplication
//@EnableDiscoveryClients
public class SettingsServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder( SettingsServiceApplication.class).
			initializers( new SpringApplicationContextInitializer())
			.application()
			.run( args);

//		SpringApplication.run(SettingsServiceApplication.class, args);
	}
}
