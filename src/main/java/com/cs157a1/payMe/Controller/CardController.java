package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Services.AccountServices;

@Controller
@SessionAttributes("accounts")
public class CardController {
	
	@Autowired
	public AccountServices accountServices;
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountServices.returnAccountByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("cards")
	public Collection<Card> getCards() {
		Collection<Card> cardList = new ArrayList<>();
		//STUBS
		cardList.add(new Card(430000000, "card", 121));
		cardList.add(new Card(430000001, "card2", 119));
		cardList.add(new Card(430000000, "card", 121));
		cardList.add(new Card(430000001, "card2", 119));
		cardList.add(new Card(430000000, "card", 121));
		cardList.add(new Card(430000001, "card2", 119));
		cardList.add(new Card(430000000, "card", 121));
		cardList.add(new Card(430000001, "card2", 119));
		return cardList;
	}
	
	@ModelAttribute("card")
	public Card getCard() {
		Card card = new Card();
		return card;
		
	}
	
	@RequestMapping("/cards")
	public String getCardList(@ModelAttribute("cards") Collection<Card> cards, ModelMap map, Principal principal) {
		map.addAllAttributes(cards);
		return "cards";
	}
	
	@RequestMapping("/cards/{cardNumber}")
	public String getCardPage(@RequestParam("card")String cardNumber, @ModelAttribute("card") Card card, ModelMap map) {
		map.addAttribute("card", card);
		return "{cardNumber}";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.GET)
	public String getCardForm(@ModelAttribute("card")Card card, ModelMap map) {
		
		map.addAttribute("card", card);
		return "addCard";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.POST)
	public String sendCardForm() {
		return "addCard";
	}
	
}
