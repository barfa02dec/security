package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	/* Chapter 1-6 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("user")
		.and().withUser("admin").password("admin").roles("admin");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//path that contains user in url can not access data who has role type ""
		http.authorizeRequests()
		//.antMatchers("/admin").hasRole("user")
		.antMatchers("/user").hasRole("user")
		.antMatchers("/admin").hasRole("admin")
		//.antMatchers("/admin").hasAnyRole("admin")
		//.antMatchers("/").permitAll();
		.and().httpBasic();
		//.and().formLogin();
		
	}

}