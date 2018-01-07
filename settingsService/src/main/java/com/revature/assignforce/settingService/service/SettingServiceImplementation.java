package com.revature.assignforce.settingService.service;

import com.revature.assignforce.settingService.domain.Setting;
import com.revature.assignforce.settingService.repositories.SettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lazar on 2/8/2017.
 */
@Service
public class SettingServiceImplementation implements SettingService {

	private SettingRepository settingRepository;

	@Autowired
	public SettingServiceImplementation ( SettingRepository sr) {
		this.settingRepository = sr;
	}

	public Setting getSettings() {
		return settingRepository.findById( Setting.getId()).orElse( null);
	}

	public Setting updateOrSaveSettings( Setting newSettings) {
		return settingRepository.save( newSettings);
	}
}
