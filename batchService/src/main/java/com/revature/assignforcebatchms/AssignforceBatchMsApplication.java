package com.revature.assignforcebatchms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.revature.assignforcebatchms", "com.revature.assignforcecommon.security"}, exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@RestController
@EnableDiscoveryClient
@EnableEurekaClient
public class AssignforceBatchMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceBatchMsApplication.class, args);
	}
}
