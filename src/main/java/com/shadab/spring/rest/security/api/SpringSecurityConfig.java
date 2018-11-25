package com.shadab.spring.rest.security.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("com.shadab.spring.rest.security")
public class SpringSecurityConfig {

	public SpringSecurityConfig() {
		super();
	}

}
