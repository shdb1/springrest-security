package com.shadab.spring.rest.security.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@ComponentScan("com.shadab.spring.rest.security")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	public WebConfig() {
		super();
	}

}
