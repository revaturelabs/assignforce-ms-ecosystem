package com.revature.assignforce.settingsservice.domain.dao;

import com.revature.assignforce.settingsservice.domain.Setting;
import com.revature.assignforcecommon.dao.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lazar on 2/8/2017.
 */
@Repository
public interface SettingRepository extends BaseRepository<Setting, Integer> {
    public Setting findByAlias(String alias);
}
