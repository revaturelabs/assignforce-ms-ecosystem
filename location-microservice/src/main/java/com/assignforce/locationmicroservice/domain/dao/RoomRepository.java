package com.assignforce.locationmicroservice.domain.dao;

import com.assignforce.locationmicroservice.domain.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ActivatableObjectRepository<Room, Integer> {

}
