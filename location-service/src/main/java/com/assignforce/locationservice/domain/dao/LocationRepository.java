package com.assignforce.locationservice.domain.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.assignforce.locationservice.domain.Location;

@Repository
public interface LocationRepository extends ActivatableObjectRepository<Location, Integer> {
    public void deleteLocationByID(ObjectId id);
}