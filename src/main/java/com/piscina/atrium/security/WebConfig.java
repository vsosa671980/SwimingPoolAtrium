package com.piscina.atrium.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
	
	//For PATH don´t pass for the controlller
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/logout").setViewName("/login");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login");
		registry.addViewController("/Errors/403").setViewName("/Errors/403");
	}
	
}
