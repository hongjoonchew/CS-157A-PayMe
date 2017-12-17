package com.cs157a1.payMe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cs157a1.payMe.Services.AdminsServices;
import com.cs157a1.payMe.Services.CommentsServices;
import com.cs157a1.payMe.Services.TransactionsServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public UsersServices userService;
	
	@Autowired
	public TransactionsServices tranService;
	
	@Autowired
	public CommentsServices cardService;
	
	@Autowired
	public AdminsServices adminService;
	
	
}
