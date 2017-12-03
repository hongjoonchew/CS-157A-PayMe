package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.CreditCardsServices;
import com.cs157a1.payMe.Services.DebitCardsServices;

@Controller
@SessionAttributes("accounts")
public class CardController {
	
	@Autowired
	public AccountServices accountServices;
	
	@Autowired
	public CreditCardsServices creditCardServices;
	
	@Autowired
	public DebitCardsServices debitCardServices;
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountServices.returnAccountByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("cards")
	public Collection<Card> getCards() {
		Collection<Card> cardList = new ArrayList<>();
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
	public String getCardPage(@PathVariable("{cardNumber}")String cardNumber, @ModelAttribute("card") Card card, ModelMap map) {
		long longCard = Long.parseLong(cardNumber); 
		if(creditCardServices.returncreditCardBycardNumber(longCard)== null) {
			card = debitCardServices.returnDebitCardBycardNumber(longCard);
		}
		else { 
			card = creditCardServices.returncreditCardBycardNumber(longCard);
		}
		map.addAttribute("card", card);
		return "{cardNumber}";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.GET)
	public String getCardForm(@ModelAttribute("card")Card card, ModelMap map) {
		map.addAttribute("card", card);
		return "addCard";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.POST)
	public String sendCardForm(@Valid @ModelAttribute("card")Card card, BindingResult results) {
		if(results.hasErrors()) {
			return "addCard";
		}
		return "addCard";
	}
	
}
