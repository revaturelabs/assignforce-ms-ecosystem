package com.revature.unavailablems.dao;

import org.springframework.stereotype.Repository;


import com.revature.unavailablems.domain.Unavailable;

@Repository
public interface UnavailableRepository extends BaseRepository<Unavailable, Integer> {

}
