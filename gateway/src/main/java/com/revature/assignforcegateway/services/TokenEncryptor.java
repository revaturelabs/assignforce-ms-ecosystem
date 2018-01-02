package com.revature.assignforcegateway.services;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

@Service
public class TokenEncryptor{

    private TextEncryptor encryptor;

    @Value("${tokenEncryption.password}")
    private String password;
    
    @Value("${tokenEncryption.salt}")
    private String salt;
    
    public TokenEncryptor(){
    }

    @PostConstruct
    public void initEncryptor(){
	encryptor = Encryptors.text(password, salt);
    }

    public String encrypt(String s){
	return encryptor.encrypt(s);
    }

    public String decrypt(String s){
	return encryptor.decrypt(s);
    }
}
