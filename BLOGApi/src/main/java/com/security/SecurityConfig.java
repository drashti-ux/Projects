package com.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager detailsManager() {
		
		UserDetails adminDetails = User.withUsername("drashti").password(encoder().encode("12345")).roles("ADMIN").build();
		UserDetails publicUser = User.withUsername("user").password(encoder().encode("1234")).roles("User").build();
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager(adminDetails,publicUser);
		
		return detailsManager;
	}
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/comments/**")
		.permitAll()
		.requestMatchers("/categories/**")
		.hasRole("ADMIN")
		.requestMatchers("/post/**")
		.hasRole("User")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}
}
