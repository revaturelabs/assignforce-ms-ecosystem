package com.revature.unavailableservice;

import com.revature.unavailableservice.dao.UnavailabilityRoomRepository;
import com.revature.unavailableservice.dao.UnavailabilityTrainerRepository;
import com.revature.unavailableservice.domain.UnavailabilityRoom;
import com.revature.unavailableservice.domain.UnavailabilityTrainer;
import com.revature.unavailableservice.service.UnavailabilityRoomService;
import com.revature.unavailableservice.service.UnavailabilityTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.List;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class AssignforceUnavailableMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignforceUnavailableMsApplication.class, args);
	}

	@Autowired
	UnavailabilityTrainerService trainerService;
	@Autowired
	UnavailabilityRoomService roomService;


	@Bean
	public CommandLineRunner demo(UnavailabilityTrainerRepository trainerRepo, UnavailabilityRoomRepository roomRepo) {
		trainerService.saveItem(new UnavailabilityTrainer(1, "1022", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
		roomService.saveItem(new UnavailabilityRoom(1, 11, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
		return (args) -> {
			// save a couple of customers
			List<UnavailabilityTrainer> trainers = trainerService.getAllItems();
			List<UnavailabilityRoom> rooms = roomService.getAllItems();
			for (UnavailabilityTrainer post : trainers) {
				System.out.println(post.toString());
			}
			for(UnavailabilityRoom room : rooms) {
				System.out.println(room.toString());
			}
		};

	}
}
