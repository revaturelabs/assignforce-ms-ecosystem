package com.revature.assignforce.settingService.repositories;

import com.revature.assignforce.settingService.domain.Setting;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
/**
 * Created by lazar on 2/8/2017.
 * Modified by Desmond George on 12/26/2017
 */

@Repository
public interface SettingRepository extends MongoRepository< Setting, String>{
	public Optional< Setting> findById( String id);
}
