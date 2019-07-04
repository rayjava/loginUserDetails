package com.services.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{ return new BCryptPasswordEncoder(); }


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		auth.userDetailsService(userDetailsService);} 
	
	@Override protected void configure(HttpSecurity http) throws Exception{ 
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		//.defaultSuccessUrl("http://localhost:1111/SAS_MAVEN_SPRING_02/")
		.defaultSuccessUrl("/registro")
		.usernameParameter("username")
		.passwordParameter("contrasena")
		.and()
		.logout()
		.permitAll(); 
		}

}
