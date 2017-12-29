package com.assignforce.locationmicroservice.service;

import com.assignforce.locationmicroservice.domain.model.Location;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LocationDaoService extends ActivatableObjectDaoService<Location, Integer> {

}
