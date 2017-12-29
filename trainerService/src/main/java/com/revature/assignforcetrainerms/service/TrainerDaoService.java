package com.revature.assignforcetrainerms.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.assignforcetrainerms.domain.Trainer;
import com.revature.assignforcetrainerms.dao.TrainerRepository;

@Transactional
@Service
public class TrainerDaoService extends ActivatableObjectDaoService<Trainer, Integer>{

	@HystrixCommand(fallbackMethod = "reliable")
	public Trainer findByFirstName(String name){
		return ((TrainerRepository) repo).findByFirstName(name);
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public Trainer findByFirstNameAndLastName(String fName, String lName){
		return ((TrainerRepository) repo).findByFirstNameAndLastName(fName, lName);
	}

	public String reliable() {
		return "TrainerDao Service Super Fallback Protection is triggered";
	}
}
