package com.revature.assignforcegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication(scanBasePackages = {"com.revature.assignforcegateway", "com.revature.assignforcecommon.security"}, exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableZuulProxy
@EnableDiscoveryClient
public class AssignforceGatewayApplication {

    // @Value("${security.oauth2.client.clientSecret}")
    // private String clientSecret;
    
    public static void main(String[] args) {
	SpringApplication.run(AssignforceGatewayApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner runner() {
    // 	return args -> {
    // 	    System.out.println(clientSecret);
    // 	};
    // }
}
