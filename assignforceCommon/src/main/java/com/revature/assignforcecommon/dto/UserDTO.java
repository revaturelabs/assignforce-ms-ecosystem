package com.revature.assignforcecommon.dto;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class UserDTO{

    private String id;
    private String role;
    private String nickname;
    private String username;
    private String firstname;
    private String lastname;
    private String picture;
    private String thumbnail;
    //private String profile;
    
    public UserDTO(){
    }

    // public UserDTO(OAuth2Authentication p){
    // 	authorities = new ArrayList<>();
    // 	for(GrantedAuthority authority : p.getAuthorities()){
    // 	    this.authorities.add(authority.getAuthority());
    // 	}
    //     Map<String, Object> details = (Map)p.getUserAuthentication().getDetails();
    // 	this.id = (String) details.get("user_id");
    // 	this.username = (String)details.get("preferred_username");
    // 	this.firstname = (String) details.get("given_name");
    // 	this.lastname = (String) details.get("family_name");
    // 	//this.profile = (String)details.get("profile");
    // 	Map<String, String> photos = (Map)details.get("photos");
    // 	this.picture = photos.get("picture");
    // 	this.thumbnail = photos.get("thumbnail");
	
    // }
 
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

    /**
     * Gets the value of role
     *
     * @return the value of role
     */
    public String getRole() {
	return this.role;
    }

    /**
     * Sets the value of role
     *
     * @param argRole Value to assign to this.role
     */
    public void setRole(final String argRole) {
	this.role = argRole;
    }

    /**
     * Gets the value of firstname
     *
     * @return the value of firstname
     */
    public String getFirstname() {
	return this.firstname;
    }

    /**
     * Sets the value of firstname
     *
     * @param argFirstname Value to assign to this.firstname
     */
    public void setFirstname(final String argFirstname) {
	this.firstname = argFirstname;
    }

    /**
     * Gets the value of lastname
     *
     * @return the value of lastname
     */
    public String getLastname() {
	return this.lastname;
    }

    /**
     * Sets the value of lastname
     *
     * @param argLastname Value to assign to this.lastname
     */
    public void setLastname(final String argLastname) {
	this.lastname = argLastname;
    }

    
    /**
     * Gets the value of id
     *
     * @return the value of id
     */
    public String getId() {
	return this.id;
    }

    /**
     * Sets the value of id
     *
     * @param argId Value to assign to this.id
     */
    public void setId(final String argId) {
	this.id = argId;
    }

    
    /**
     * Gets the value of nickname
     *
     * @return the value of nickname
     */
    public final String getNickname() {
	return this.nickname;
    }

    /**
     * Sets the value of nickname
     *
     * @param argNickname Value to assign to this.nickname
     */
    public final void setNickname(final String argNickname) {
	this.nickname = argNickname;
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
