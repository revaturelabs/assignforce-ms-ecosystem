package com.revature.assignforce.settingService.domain.dao;

import com.revature.assignforce.settingService.domain.Setting;
import com.revature.assignforcecommon.dao.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lazar on 2/8/2017.
 */
@Repository
public interface SettingRepository extends BaseRepository<Setting, Integer> {
    public Setting findByAlias(String alias);
}
