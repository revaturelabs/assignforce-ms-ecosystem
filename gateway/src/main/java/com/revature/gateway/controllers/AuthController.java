package com.revature.gateway.controllers;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthController{

    @Value("${frontEndUrl}")
    private static String frontEndUrl;
    
    @RequestMapping(value= "/auth/userinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Principal> userInfo(Principal principal){
	return new ResponseEntity<Principal>(principal, HttpStatus.OK);
    }
    
    @RequestMapping(value= "/login**")
    public ResponseEntity login(){
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public void home(HttpServletResponse response) throws IOException{
	response.sendRedirect(frontEndUrl + "/overview");
    }
    
}
