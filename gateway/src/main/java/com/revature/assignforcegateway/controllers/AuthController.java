package com.revature.assignforcegateway.controllers;

import com.revature.assignforcecommon.security.TokenEncryptor;
import com.revature.assignforcecommon.security.SalesforceRest;
import com.revature.assignforcecommon.dto.UserDTO;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.access.prepost.PreAuthorize;

import java.security.Principal;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

@Controller
public class AuthController{

    @Value("${frontEndUrl}")
    private String frontEndUrl;

    @Value("${salesforce.oauth2.client.revokeTokenUri}")
    private String revokeUri;
    
    @Autowired
    private RestTemplate template;

    @Autowired
    private TokenEncryptor encryptor;

    @Autowired
    private SalesforceRest salesforceRest;
    
    @Bean
    public RestTemplate rt(RestTemplateBuilder builder) {
	return builder.build();
    }
    
    @RequestMapping(value= "/auth/userinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> userInfo(OAuth2Authentication principal){
	//Map<String, Object> details = (Map)principal.getUserAuthentication().getDetails();
	//System.out.println(details.get("photos").getClass());
							      
	return new ResponseEntity<UserDTO>(salesforceRest.getCurrentUser(principal.getUserAuthentication()), HttpStatus.OK);
    }

    @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(value= "/login**")
    public String login(OAuth2Authentication principal){
	OAuth2AuthenticationDetails details =
	    (OAuth2AuthenticationDetails)principal.getDetails();
	String token = encryptor.encrypt(details.getTokenValue());
	String redirectUrl = frontEndUrl + "/loginsuccess" + "?token=" + token;
	
	return "redirect:" + redirectUrl;
    }

    // @RequestMapping(value= "/", method = RequestMethod.GET)
    // public void home(HttpServletResponse response) throws IOException{
    // 	response.sendRedirect(frontEndUrl + "/overview");
    // }

    @RequestMapping(value= "/revokelogout", method = RequestMethod.POST)
    public ResponseEntity logout(OAuth2Authentication principal){
	OAuth2AuthenticationDetails details =
	    (OAuth2AuthenticationDetails)principal.getDetails();
	String token = details.getTokenValue();
	String revokeUrl = revokeUri + "?token=" + token; 
	ResponseEntity resp = template.getForEntity(revokeUrl, String.class);

	ResponseEntity ret = null;
	if(resp.getStatusCode() == HttpStatus.OK){
	    ret = new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	else {
	    ret = new ResponseEntity(resp.getStatusCode());
	}

	return ret;
    }
}
