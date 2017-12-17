package com.cs157a1.payMe.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	 
	@Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/home").setViewName("home");
	        registry.addViewController("/").setViewName("home");
	        registry.addViewController("/hello").setViewName("hello");
	        registry.addViewController("/login").setViewName("login");
	        registry.addViewController("/accounts").setViewName("accounts");
	        registry.addViewController("/signup").setViewName("signup");
	        registry.addViewController("/dashboard").setViewName("dashboard");
	        registry.addViewController("/friends").setViewName("friends");     
	        registry.addViewController("/cards").setViewName("cards");
	        registry.addViewController("/{username}").setViewName("{username}");
	        registry.addViewController("/friends/add").setViewName("addFriend");
	        registry.addViewController("/cards/{cardNumber}").setViewName("{cardNumber}");
	        registry.addViewController("/view").setViewName("view");
	        registry.addViewController("/transaction").setViewName("transaction");
	        registry.addViewController("/request/view").setViewName("requestForm");
	        registry.addViewController("/transaction/{id}/addComment").setViewName("addComment");
	        registry.addViewController("/admin").setViewName("admin");
	        registry.addViewController("/admin/transaction").setViewName("adminTransaction");
	        registry.addViewController("/admin/users").setViewName("adminUsers");
	        registry.addViewController("/admin/cards").setViewName("adminCards");
	        registry.addViewController("/admin/requests").setViewName("adminRequests");
	    }
	
	
}

