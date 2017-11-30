package com.cs157a1.payMe.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Services.AccountServices;

@Controller
public class SignUpController {
	
	@Autowired
	private AccountServices accountServices;
	
	@ModelAttribute("accounts")
	public Account getAccount(){
		Account account = new Account();
		return account;
	}
	
	@RequestMapping(value="/signup",method = RequestMethod.GET)
	public String showForm(Model model, @ModelAttribute("accounts") Account account){
		model.addAttribute(account);
		return "signup";
	}
	
	// value == root
	// Model == page
	
	@RequestMapping(value ="/signup", method = RequestMethod.POST)
	public String addAccountToDB(@Valid @ModelAttribute("accounts")  Account account, BindingResult result) {
		if(result.hasErrors()) {
			return "signup";
		}
		else {
		accountServices.addAccounttoDB(account);
		return "redirect:/home?complete";
		}
	}
	
	// submit button
	// result.error checks if form is empty
	
}
