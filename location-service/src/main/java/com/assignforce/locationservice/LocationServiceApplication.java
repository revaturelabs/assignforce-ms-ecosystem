package com.assignforce.locationservice;

import com.assignforce.locationservice.domain.Location;
import com.assignforce.locationservice.domain.dao.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LocationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(LocationRepository dao) {
//		return args -> {
////			List<ChinookAlbum> a = dao.findAll();
////			for(ChinookAlbum t : a) {
////				System.out.println(t);
////			}
//			Location location = new Location();
//			location.setName("CUNY");
//			location.setCity("New York");
//			location.setState("NY");
//			location.setActive(true);
//			location.setID(1);
//			dao.save(location);
//		};
//	}
}
