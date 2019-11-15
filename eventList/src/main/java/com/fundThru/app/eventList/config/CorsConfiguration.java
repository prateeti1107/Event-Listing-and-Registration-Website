package com.fundThru.app.eventList.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/rest/v2//**").allowedMethods("PUT", "DELETE");
//            }
//        };
//    }
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/rest/v2/**").allowedMethods("PUT", "DELETE");
    }
}
