package com.revature.assignforce.location.services;

import com.revature.assignforce.location.model.Location;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class LocationDaoService extends ActivatableObjectDaoService<Location, Integer> {

}