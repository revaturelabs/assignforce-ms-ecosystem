package com.revature.assignforcecommon.security;

import com.revature.assignforcecommon.security.SalesforceRest;
import com.revature.assignforcecommon.dto.UserDTO;
import com.revature.assignforcecommon.domain.Trainer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSecurity implements PermissionEvaluator {

    @Autowired
    private SalesforceRest salesforceRest;

    private HashMap<String, List<String>> permissions;

    private ArrayList<String> addPrivilages(String... args){
        ArrayList<String> privilages = new ArrayList<>();
        for(String s: args){
            privilages.add(s);
        }
        return privilages;
    }

    public CustomSecurity() {
        permissions = new HashMap<>();
        permissions.put("Trainers", addPrivilages("basic", "trainer_profile"));
        permissions.put("VP of Technology", addPrivilages("basic", "manager"));
    }

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if (auth != null && permission instanceof String) {
            UserDTO u = salesforceRest.getCurrentUser(((OAuth2Authentication) auth).getUserAuthentication());

            if (targetDomainObject instanceof Trainer) {
                Trainer t = ((Trainer) targetDomainObject);
                String trainerId = t.getSalesforceId();
                String userId = u.getId();
                if(!trainerId.equals(userId))
                    return false;
            }

            for(String s : permissions.get(u.getRole()))
                if(s.equals((String)permission))
                    return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
