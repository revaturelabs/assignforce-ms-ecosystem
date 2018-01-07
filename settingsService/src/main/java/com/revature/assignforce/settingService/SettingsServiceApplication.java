package com.revature.assignforce.settingService;

import com.revature.assignforce.settingService.config.SpringApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/*
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
*/

@EnableMongoRepositories(basePackages = "com.revature.assignforce.settingService")
@SpringBootApplication
//@EnableDiscoveryClient
public class SettingsServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder( SettingsServiceApplication.class).
			initializers( new SpringApplicationContextInitializer())
			.application()
			.run( args);

//		SpringApplication.run(SettingsServiceApplication.class, args);
	}
}
