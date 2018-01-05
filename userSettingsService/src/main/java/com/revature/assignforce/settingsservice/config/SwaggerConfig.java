package com.revature.assignforce.settingsService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by August Duet on 9/19/2017.
 * Modified by Desmond George on 12/26/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userSettingsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.
						basePackage("com.revature.assignforce.userSettingsService.web"))
                .paths(regex("/settings/{userId}"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        ApiInfo info = new ApiInfo(
                "User Settings API",     //title
                "User Settings API for User Settings microservice",  //description
                "1.0.0",         //version
                "Terms of Service",     //terms if Service url
                new Contact("August Duet", "http://www.revature.com", "august.duet@revature.com"),
                "Apache License Version 2.0",        //license info
                "https://apache.org/licenses/LICENSE-2.0");
        return info;
    }
}
