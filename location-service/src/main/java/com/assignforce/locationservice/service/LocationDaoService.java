package com.assignforce.locationservice.service;

import com.assignforce.locationservice.domain.dao.BaseRepository;
import com.assignforce.locationservice.domain.dao.LocationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignforce.locationservice.domain.Location;

@Transactional
@Service
public class LocationDaoService extends ActivatableObjectDaoService<Location, Integer> {

    @Autowired
    protected LocationRepository repo;

    public void deleteLocationByID(ObjectId id){
        repo.deleteLocationByID(id);
    }
}
