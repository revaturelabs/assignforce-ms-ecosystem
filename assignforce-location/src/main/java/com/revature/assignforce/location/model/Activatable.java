package com.revature.assignforce.location.model;

/**
 * Created by August Duet on 11/29/2016.
 */
//Sonarqube said to add this annotation - may be optional
@FunctionalInterface
public interface Activatable {

    void setActive(Boolean active);
}
