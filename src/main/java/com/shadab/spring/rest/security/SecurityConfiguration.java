package com.shadab.spring.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM="MY_TEST_REALM";
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("johny").password("johnysecured").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("tomy").password("tom123").roles("USER");
		
		
		/* auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
		"select username,password, enabled from students where username=?")
		.authoritiesByUsernameQuery(
		"select username, role from rioles where username=?");*/
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/user/**").hasRole("ADMIN")
		.and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());
 	}
	
	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	}
	
   
}
