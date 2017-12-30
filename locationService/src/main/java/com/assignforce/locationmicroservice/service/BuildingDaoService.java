package com.assignforce.locationmicroservice.service;

import com.assignforce.locationmicroservice.domain.model.Building;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BuildingDaoService extends ActivatableObjectDaoService<Building, Integer> {

}
