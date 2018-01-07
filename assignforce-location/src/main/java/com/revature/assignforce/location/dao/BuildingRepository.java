package com.revature.assignforce.location.dao;

import com.revature.assignforce.location.model.Building;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends ActivatableObjectRepository<Building, Integer> {
}