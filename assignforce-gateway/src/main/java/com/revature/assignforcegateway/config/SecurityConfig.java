package com.revature.assignforcegateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


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
		.cors().and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		    
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
        configuration.setAllowedHeaders(Arrays.asList(new String[]{"Cache-Control", "Content-Type", "X-XSRF-TOKEN"}));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
