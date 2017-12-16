package com.revature.assignforcegateway.controllers;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AuthController{

    @RequestMapping(value= "/auth/userinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Principal> userInfo(Principal principal){
	return new ResponseEntity<Principal>(principal, HttpStatus.OK);
    }
    
    @RequestMapping(value= "/login**")
    public ResponseEntity login(Principal principal){
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value= "/home", method = RequestMethod.GET)
    public ResponseEntity home(Principal principal){
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
    
}
