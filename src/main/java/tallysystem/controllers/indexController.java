package tallysystem.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tallysystem.models.TallyCard;
import tallysystem.services.TallyCardService;

@RestController
@RequestMapping(value = "/")
public class indexController {


	@Autowired 
	private TallyCardService cardsService;
	
	// end mock data

	@RequestMapping(value = "newCard/{cardName}", method = RequestMethod.POST)
	public ResponseEntity<TallyCard> createNewCard(@PathVariable("cardName") String cardName) {
		TallyCard card = new TallyCard();
		card.setName(cardName);
		cardsService.saveCard(card);
		return new ResponseEntity<TallyCard>(card, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "getAllCards", method = RequestMethod.GET)
	public Collection<TallyCard> getAllCards() {
		return cardsService.getAllCards();
	}

	@RequestMapping(value = "updateCount/{cardName}/{count}", method = RequestMethod.GET)
	public void setCardCount(@PathVariable("cardName") String cardName, @PathVariable("count") String count) {
		TallyCard card = cardsService.getCardByName(cardName);
		card.setCount(Integer.parseInt(count));
		cardsService.saveCard(card);
	}

	@RequestMapping(value = "removeCard/{cardName}", method = RequestMethod.DELETE)
	public void removeCard(@PathVariable("cardName") String cardName) {
		cardsService.removeCardByName(cardName);
	}


}
