package com.revature.assignforce.location.services;

import com.revature.assignforce.location.model.Building;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BuildingDaoService extends ActivatableObjectDaoService<Building, Integer> {
	
	@Autowired
	BuildingRepository buildingRepo;
}