package com.revature.assignforcecommon.security;

import com.revature.assignforcecommon.dto.UserDTO;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

@Service
public class SalesforceRest{

    private static final String REST_VERSION = "42.0";
    
    private OAuth2RestTemplate restTemplate;

    private ObjectMapper om;
    
    @Autowired
    public SalesforceRest(OAuth2ProtectedResourceDetails resourceDetails, OAuth2ClientContext clientContext) {
        this.restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
	this.om = new ObjectMapper();
    }
    
    public UserDTO getCurrentUser(Authentication auth){
	Map<String, Object> details = (Map)auth.getDetails();
	Map<String, String> urls = (Map)details.get("urls");
	// String url = urls.get("sobjects").replace("{version}", REST_VERSION) + "User" + details.get("user_id");

	String query = "SELECT Id, Name, CommunityNickname, FirstName, LastName, Username, FullPhotoUrl, SmallPhotoUrl, " +
	    "UserRole.Id, UserRole.Name " +
	    "FROM User WHERE Id = '" + details.get("user_id") + "'";	
	String url = urls.get("query").replace("{version}", REST_VERSION) + "?q={q}";

	Map<String, String> params = new HashMap<>();
        params.put("q", query);

	System.out.println(url);
	String respJson = restTemplate.getForObject(url, String.class, params);

	JsonNode node = null;
	try{
	  node = om.readTree(respJson);
	}
	catch(IOException ex){
	    System.out.println("This shouldn't happen, we're reading from a string");
	}
	
	JsonNode userJson = node.get("records").get(0);
	JsonNode roleJson = userJson.get("UserRole");
	
	UserDTO ret = new UserDTO();
	ret.setId(userJson.get("Id").asText());
	ret.setFirstname(userJson.get("FirstName").asText());
	ret.setLastname(userJson.get("LastName").asText());
	ret.setNickname(userJson.get("CommunityNickname").asText());
	ret.setUsername(userJson.get("Username").asText());
	ret.setPicture(userJson.get("FullPhotoUrl").asText());
	ret.setThumbnail(userJson.get("SmallPhotoUrl").asText());
	ret.setRole(roleJson.get("Name").asText());

	return ret;
    }
    
}
