package com.revature.assignforcecommon.domain;

/**
 * Created by August Duet on 11/29/2016.
 */
//Sonarqube said to add this annotation - may be optional
public interface Activatable {

    void setActive(Boolean active);
    Boolean getActive();
}
