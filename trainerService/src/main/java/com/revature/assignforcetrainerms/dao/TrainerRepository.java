package com.revature.assignforcetrainerms.dao;

import org.springframework.stereotype.Repository;


import com.revature.assignforcetrainerms.domain.Trainer;

import java.util.List;

@Repository
public interface TrainerRepository extends ActivatableObjectRepository<Trainer, Integer> {
	Trainer findByFirstName(String name);
	Trainer findByFirstNameAndLastName(String firstName, String lastName);
	List<Trainer> findByActiveIsTrue();
	//Trainer findById(Integer id);
}
