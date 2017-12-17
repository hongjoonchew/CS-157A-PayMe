package com.cs157a1.payMe.Controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/", "/home","/signup","/css/**").permitAll()
	                .antMatchers("/admin/**","/admin").hasAuthority("ADMIN")
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    		String userAuth = "SELECT username, password, enabled FROM accounts WHERE username = ?";
	    		String userAccess = "SELECT username, authorities FROM accessControl WHERE username =?";
	        auth
	        		.jdbcAuthentication().dataSource(datasource)
	        		.usersByUsernameQuery(userAuth)
	        		.authoritiesByUsernameQuery(userAccess);
	        
	    		
	    }
	
}
