package com.revature.assignforcetrainerms.service;

import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.assignforcetrainerms.domain.Trainer;
import com.revature.assignforcetrainerms.dao.TrainerRepository;

@Transactional
@Service
public class TrainerDaoService extends ActivatableObjectDaoService<Trainer, Integer>{

	public Trainer findByFirstName(String name){
		return ((TrainerRepository) repo).findByFirstName(name);
	}

	public Trainer findByFirstNameAndLastName(String fName, String lName){
		return ((TrainerRepository) repo).findByFirstNameAndLastName(fName, lName);
	}
}
