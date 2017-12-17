package com.cs157a1.payMe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs157a1.payMe.Entity.Transactions;
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
	
	@ModelAttribute("transactions")
	public Transactions getTrans() {
		return new Transactions();
	}
	
	
	@RequestMapping("/transactions")
	public String transactions(ModelMap map) {
		List<Transactions> trans = tranService.returnAllInfo();
		map.addAttribute("trans",trans);
		return "adminTransaction";
	}
	
	@RequestMapping(value="/transactions/delete", method = RequestMethod.POST)
	public String deleteTransaction(@ModelAttribute("id") int id) {
		tranService.deleteTransactions(id);
		return "redirect:/admin/transactions";
	}
	
	@RequestMapping("/users")
	public String users(ModelMap map) {
		return null;
	}
	
	@RequestMapping("/cards")
	public String cards(ModelMap map) {
		return null;
	}
	
	@RequestMapping("/requests")
	public String requests(ModelMap map) {
		return null;
	}
}
