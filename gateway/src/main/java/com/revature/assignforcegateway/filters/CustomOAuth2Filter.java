package com.revature.assignforcegateway.filters;

import com.revature.assignforcegateway.services.TokenEncryptor;

import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;

import java.io.IOException;


public class CustomOAuth2Filter
    extends OAuth2ClientAuthenticationProcessingFilter{

    private ResourceServerTokenServices tokenServices;

    private AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();

    private TokenEncryptor encryptor;
    
    public CustomOAuth2Filter(String defaultFilterProcessesUrl){
	super(defaultFilterProcessesUrl);
    }

    @Override
    public void setTokenServices(ResourceServerTokenServices tokenServices) {
	super.setTokenServices(tokenServices);
	this.tokenServices = tokenServices;
    }

    @Override
    public void afterPropertiesSet() {
	super.afterPropertiesSet();
	initFilterBean();
    }

    @Override
    protected void initFilterBean(){
	encryptor = WebApplicationContextUtils
	    .getRequiredWebApplicationContext(getServletContext())
	    .getBean(TokenEncryptor.class);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
						HttpServletResponse response)
	throws AuthenticationException, IOException, ServletException{
	String token = request.getHeader("X-AUTH-TOKEN");
	OAuth2AccessToken accessToken;
	
	if(token == null){
	    try {
	    	accessToken = restTemplate.getAccessToken();
	    } catch (OAuth2Exception e) {
	    	BadCredentialsException bad = new BadCredentialsException("Could not obtain access token", e);	
	    	throw bad;			
	    }
	} else{
	    accessToken = new DefaultOAuth2AccessToken(encryptor.decrypt(token));
	}

	try {
	    System.out.println(accessToken.getValue());
	    OAuth2Authentication result = tokenServices.loadAuthentication(accessToken.getValue());
	    if (authenticationDetailsSource!=null) {
		request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, accessToken.getValue());
		request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, accessToken.getTokenType());
		result.setDetails(authenticationDetailsSource.buildDetails(request));
	    }
		
	    return result;
	} catch (InvalidTokenException e) {
	    BadCredentialsException bad = new BadCredentialsException("Could not obtain user details from token", e);
	    throw bad;			
	}	
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
					    HttpServletResponse response,
					    FilterChain chain,
					    Authentication authResult)
	throws IOException, ServletException {
	SecurityContextHolder.getContext().setAuthentication(authResult);
	restTemplate.getAccessToken();
	chain.doFilter(request, response);
    }
 
}
