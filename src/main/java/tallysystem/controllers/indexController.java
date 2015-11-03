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
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		TallyCard card = new TallyCard();
		card.setName(cardName);
		tallyCards.put(cardName, card);
		cardsService.saveCard(card);
		
		return new ResponseEntity<TallyCard>(card, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "getCard/{cardName}", method = RequestMethod.GET)
	public TallyCard getCard(@PathVariable("cardName") String cardName) {
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		TallyCard card = tallyCards.get(cardName);
		return card;

	}

	@RequestMapping(value = "getAllCards", method = RequestMethod.GET)
	public Collection<TallyCard> getAllCards() {

		return cardsService.getAllCards();
	}

	@RequestMapping(value = "updateCount/{cardName}/{count}", method = RequestMethod.GET)
	public void setCardCount(@PathVariable("cardName") String cardName, @PathVariable("count") String count) {
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		TallyCard card = tallyCards.get(cardName);
		card.setCount(Integer.parseInt(count));

	}

	@RequestMapping(value = "removeCard/{cardName}", method = RequestMethod.DELETE)
	public String removeCard(@PathVariable("cardName") String cardName) {
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		tallyCards.remove(cardName);
		return cardName + " removed.";

	}

	@RequestMapping(value = "removeAllCards", method = RequestMethod.GET)
	public String removeAllCards() {
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		tallyCards.clear();
		return "all cards are removed.";

	}

	// helper methods
	public String getAllStringFromMap() {
		HashMap<String, TallyCard> tallyCards = cardsService.makeCards();
		Iterator iterator = tallyCards.entrySet().iterator();
		String text = "";
		while (iterator.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry) iterator.next();
			text += pair.getValue().toString() + "\n\n";
		}
		if (text == "")
			text = "no cards found.";
		return text;
	}

}
