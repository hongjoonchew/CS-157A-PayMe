package com.cs157a1.payMe.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.AdminsServices;
import com.cs157a1.payMe.Services.CommentsServices;
import com.cs157a1.payMe.Services.CreditCardsServices;
import com.cs157a1.payMe.Services.DebitCardsServices;
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
	public CommentsServices commentService;
	
	@Autowired
	public DebitCardsServices debitCardService;
	
	@Autowired
	public CreditCardsServices creditCardService;
	
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
		List<User> users = userService.returnAllInfo();
		map.addAttribute("users", users);
		return "adminUsers";
	}
	
	@RequestMapping(value="/users/delete", method =RequestMethod.POST)
	public String deleteUser(@ModelAttribute("username") String username) {
		userService.deleteUser(username);
		return "redirect:/admin/users";
	}
	
	@RequestMapping("/cards")
	public String cards(ModelMap map) {
		List<Card> cards = new ArrayList<>();
		cards.addAll(creditCardService.returnAllInfo());
		cards.addAll(debitCardService.returnAllInfo());
		map.addAttribute("cards",cards);
		return "adminCards";
	}
	
	@RequestMapping(value="/cards/delete", method =RequestMethod.POST)
	public String deleteCard(@ModelAttribute("cardNumber") Long cardNumber, @ModelAttribute("cardType") String cardType) {
		if(cardType.equals("Debit")) {
			debitCardService.deleteDebitCard(cardNumber);
		}
		else {
			creditCardService.deletecreditCard(cardNumber);
		}
		return "redirect:/admin/cards";
	}
		
	@RequestMapping("/comments")
	public String comments(ModelMap map) {
		List<Comment> comments = commentService.returnAllInfo();
		map.addAttribute("comments",comments);
		return "adminComments";
	}
	
	@RequestMapping(value="/comments/delete", method=RequestMethod.POST)
	public String deleteComment(@ModelAttribute("commentId")int commentId) {
		commentService.deleteComment(commentId);
		return "redirect:/admin/comments";
	}
}
