package com.revature.assignforce.settingService.repositories;

import org.springframework.stereotype.Repository;
import com.revature.assignforce.settingService.domain.Setting;
import com.revature.assignforce.settingService.repositories.BaseRepository;

import java.io.Serializable;
/**
 * Created by lazar on 2/8/2017.
 * Modified by Desmond George on 12/26/2017
 */

@Repository
public interface SettingRepository extends BaseRepository< Setting, String> {
	Setting findById( String id);
}
