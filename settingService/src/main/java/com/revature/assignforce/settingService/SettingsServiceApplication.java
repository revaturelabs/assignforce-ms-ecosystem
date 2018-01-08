package com.revature.assignforce.settingService;

import com.revature.assignforce.settingService.config.SpringApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.revature.assignforce.settingService")
@SpringBootApplication()
public class SettingsServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder( SettingsServiceApplication.class).
			initializers( new SpringApplicationContextInitializer())
			.application()
			.run( args);
	}
}
