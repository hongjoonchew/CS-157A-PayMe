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
import com.cs157a1.payMe.Entity.CreditCard;
import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.CreditCardsServices;
import com.cs157a1.payMe.Services.DebitCardsServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@SessionAttributes("accounts")
public class CardController {
	
	@Autowired
	public AccountServices accountServices;
	
	@Autowired
	public CreditCardsServices creditCardServices;
	
	@Autowired
	public DebitCardsServices debitCardServices;
	
	@Autowired
	private UsersServices userServices;
	
	@ModelAttribute("accounts")
	public User getAccount(Principal principal){
		User account = userServices.returnUserByUsername(principal.getName());
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
		cards.addAll(userServices.returnCardBelongToUser(principal.getName()));
		map.addAllAttributes(cards);
		return "cards";
	}
	
	@RequestMapping("/cards/{cardNumber}")
	public String getCardPage(@PathVariable("cardNumber")String cardNumber, @ModelAttribute("card") Card card, ModelMap map) {
		long longNum = Long.parseLong(cardNumber);
		DebitCard debit = debitCardServices.returnDebitCardBycardNumber(longNum);
		CreditCard credit = creditCardServices.returncreditCardBycardNumber(longNum);
		map.addAttribute("card", card);
		return "{cardNumber}";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.GET)
	public String getCardForm(@ModelAttribute("card")Card card, ModelMap map) {
		map.addAttribute("card", card);
		return "addCard";
	}
	
	@RequestMapping(value="/cards/addCard", method = RequestMethod.POST)
	public String sendCardForm(@Valid @ModelAttribute("card")Card card, @ModelAttribute("accounts") Account account, BindingResult results) {
		if(results.hasErrors()) {
			return "addCard";
		}
		String type = card.getCardType();
		card.setUser(userServices.returnUserByUsername(account.getUsername()));
		if(type.equals("Debit")) {
			DebitCard debit = new DebitCard(card,1000);
			debit.setType("Visa");
			debitCardServices.addDebitCardToDB(debit,account.getUsername());
		}
		else if(type.equals("Credit")) {
			CreditCard credit = new CreditCard(card,1000);
			creditCardServices.addcreditCardToDB(credit,account.getUsername());
		}
		return "redirect:/addCard?complete";
	}
	
}
