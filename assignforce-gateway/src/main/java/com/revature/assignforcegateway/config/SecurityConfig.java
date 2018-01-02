package com.revature.assignforcegateway.config;

import com.revature.assignforcegateway.filters.CustomOAuth2Filter;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import javax.servlet.Filter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.ServletContext;

import java.util.Arrays;



/**
 * Created by Marquis on 7/12/2017.
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    ServletContext context; 
    
    @Bean
    public FilterRegistrationBean
	oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter(filter);
	registration.setOrder(-100);
	return registration;
    }
    
    private CustomOAuth2Filter customOAuth2Filter() {
        CustomOAuth2Filter salesforceFilter = new CustomOAuth2Filter("/**");
	OAuth2RestTemplate salesforceTemplate = new OAuth2RestTemplate(salesforce(), oauth2ClientContext);
	salesforceFilter.setServletContext(context);
	salesforceFilter.setRestTemplate(salesforceTemplate);
	UserInfoTokenServices tokenServices = new UserInfoTokenServices(salesforceResource().getUserInfoUri(), salesforce().getClientId());
	tokenServices.setRestTemplate(salesforceTemplate);
	salesforceFilter.setTokenServices(tokenServices);
	salesforceFilter.afterPropertiesSet();
	return salesforceFilter;
    } 

    private Filter ssoFilter() {
	OAuth2ClientAuthenticationProcessingFilter salesforceFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
	OAuth2RestTemplate salesforceTemplate = new OAuth2RestTemplate(salesforce(), oauth2ClientContext);
	salesforceFilter.setRestTemplate(salesforceTemplate);
	UserInfoTokenServices tokenServices = new UserInfoTokenServices(salesforceResource().getUserInfoUri(), salesforce().getClientId());
	tokenServices.setRestTemplate(salesforceTemplate);
	salesforceFilter.setTokenServices(tokenServices);
	return salesforceFilter;
    } 

    @Bean
    @ConfigurationProperties("salesforce.oauth2.client")
    public AuthorizationCodeResourceDetails salesforce() {
	return new AuthorizationCodeResourceDetails();
    }

    
    @Bean
    @Primary
    @ConfigurationProperties("salesforce.oauth2.resource")
    public ResourceServerProperties salesforceResource() {
	return new ResourceServerProperties();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// require https
	http.requiresChannel().antMatchers("/**").requiresSecure().and().portMapper().http(80).mapsTo(443);
	    
	http.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and()
	    .cors().and()
	    .csrf().disable()
	    .addFilterBefore(customOAuth2Filter(), BasicAuthenticationFilter.class)
	    //.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
	    .sessionManagement()
	    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    //.addFilterBefore(new ExceptionTranslationFilter(),
	    //ExceptionTranslationFilter.class);
		    
	//.and().formLogin().loginPage("/").loginProcessingUrl("/login").defaultSuccessUrl("/home");	
	
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(new String[]{"http://localhost:4200"}));
        configuration.setAllowedMethods(Arrays.asList(new String[]{"HEAD",
		    "GET", "POST", "PUT", "DELETE", "PATCH"}));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList(new String[]{"Cache-Control", "Content-Type", "X-AUTH-TOKEN"}));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
