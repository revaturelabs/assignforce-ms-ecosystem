package com.revature.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Marquis on 7/12/2017.
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// require https
	    http.requiresChannel().antMatchers("/**").requiresSecure().and().portMapper().http(80).mapsTo(443);
	    
	    http.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		    
		    //.and().formLogin().loginPage("/").loginProcessingUrl("/login").defaultSuccessUrl("/home");
	}
}
