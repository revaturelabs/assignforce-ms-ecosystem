package com.assignforce.locationmicroservice.domain.dao;

import com.assignforce.locationmicroservice.domain.model.Building;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends ActivatableObjectRepository<Building, Integer> {

}
