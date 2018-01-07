package com.revature.assignforce.settingService;

//import com.revature.assignforce.settingService.config.SpringApplicationContextInitializer;
import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

//@EnableMongoRepositories(basePackages = "com.revature.assignforce.settingService")
@SpringBootApplication
//@EnableDiscoveryClients
public class SettingsServiceApplication {

	public static void main(String[] args) {
		/*
		new SpringApplicationBuilder( SettingsServiceApplication.class).
			initializers( new SpringApplicationContextInitializer())
			.application()
			.run( args);
			*/
		SpringApplication.run(SettingsServiceApplication.class, args);
	}
}
