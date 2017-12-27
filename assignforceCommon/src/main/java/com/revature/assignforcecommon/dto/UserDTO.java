package com.revature.assignforcecommon.dto;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class UserDTO{

    private List<String> authorities;
    private String username;
    private String picture;
    private String thumbnail;
    //private String profile;
    
    public UserDTO(){
    }

    public UserDTO(OAuth2Authentication p){
	authorities = new ArrayList<>();
	for(GrantedAuthority authority : p.getAuthorities()){
	    this.authorities.add(authority.getAuthority());
	}
        Map<String, Object> details = (Map)p.getUserAuthentication().getDetails();
	this.username = (String)details.get("preferred_username");
	//this.profile = (String)details.get("profile");
	Map<String, String> photos = (Map)details.get("photos");
	this.picture = photos.get("picture");
	this.thumbnail = photos.get("thumbnail");
	
    }
    
    /**
     * Gets the value of authorities
     *
     * @return the value of authorities
     */
    public List<String> getAuthorities() {
	return this.authorities;
    }

    /**
     * Sets the value of authorities
     *
     * @param argAuthorities Value to assign to this.authorities
     */
    public void setAuthorities(List <String> argAuthorities) {
	this.authorities = argAuthorities;
    }

    /**
     * Gets the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
	return this.username;
    }

    /**
     * Sets the value of username
     *
     * @param argUsername Value to assign to this.username
     */
    public void setUsername(final String argUsername) {
	this.username = argUsername;
    }

    /**
     * Gets the value of picture
     *
     * @return the value of picture
     */
    public String getPicture() {
	return this.picture;
    }

    /**
     * Sets the value of picture
     *
     * @param argPicture Value to assign to this.picture
     */
    public void setPicture(final String argPicture) {
	this.picture = argPicture;
    }

    /**
     * Gets the value of thumbnail
     *
     * @return the value of thumbnail
     */
    public String getThumbnail() {
	return this.thumbnail;
    }

    /**
     * Sets the value of thumbnail
     *
     * @param argThumbnail Value to assign to this.thumbnail
     */
    public void setThumbnail(final String argThumbnail) {
	this.thumbnail = argThumbnail;
    }

    // /**
    //  * Gets the value of profile
    //  *
    //  * @return the value of profile
    //  */
    // public String getProfile() {
    // 	return this.profile;
    // }

    // /**
    //  * Sets the value of profile
    //  *
    //  * @param argProfile Value to assign to this.profile
    //  */
    // public void setProfile(final String argProfile) {
    // 	this.profile = argProfile;
    // }

}
