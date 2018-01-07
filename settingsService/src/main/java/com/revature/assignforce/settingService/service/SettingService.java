package com.revature.assignforce.settingService.service;

import com.revature.assignforce.settingService.domain.Setting;
//import com.revature.assignforce.settingService.domain.dao.SettingRepository;
//import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lazar on 2/8/2017.
 */
//@Transactional
//@Service
public interface SettingService {

	/*
	Setting getSettings();
	Setting saveOrUpdateSettings( Setting newSetting);
    public Setting getGlobalSettings(){
        SettingRepository dao = (SettingRepository) repo;
        return dao.findByAlias("global");
    }
	*/

	public Setting getSettings(); 

	public Setting updateOrSaveSettings( Setting newSettings);
}
