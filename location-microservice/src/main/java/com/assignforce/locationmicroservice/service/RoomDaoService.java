package com.assignforce.locationmicroservice.service;

import com.assignforce.locationmicroservice.domain.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoomDaoService extends ActivatableObjectDaoService<Room, Integer> {

}
