package tallysystem.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tallysystem.models.TallyCard;
import tallysystem.services.TallyCardService;

@RestController
@RequestMapping(value = "/")
public class indexController {

	TallyCardService cardService = new TallyCardService();
	@Autowired 
	private TallyCardService cardsService;
	
	private HashMap<String, TallyCard> tallyCards = cardService.makeCards();
	// end mock data

	@RequestMapping(value = "newCard/{cardName}", method = RequestMethod.POST)
	public void createNewCard(@PathVariable("cardName") String cardName) {
		TallyCard card = new TallyCard(cardName);
		tallyCards.put(cardName, card);
		cardsService.createCard(card);
	}
	
	@RequestMapping(value = "newCard/{cardName}", method = RequestMethod.GET)
	public void insertNewCard(@PathVariable("cardName") String cardName) {
		TallyCard card = new TallyCard(cardName);
		cardsService.createCard(card);
	}

	@RequestMapping(value = "getCard/{cardName}", method = RequestMethod.GET)
	public TallyCard getCard(@PathVariable("cardName") String cardName) {
		TallyCard card = tallyCards.get(cardName);
		return card;

	}

	@RequestMapping(value = "getAllCards", method = RequestMethod.GET)
	public Collection<TallyCard> getAllCards() {

		return tallyCards.values();
	}

	@RequestMapping(value = "updateCount/{cardName}/{count}", method = RequestMethod.GET)
	public void setCardCount(@PathVariable("cardName") String cardName, @PathVariable("count") String count) {
		TallyCard card = tallyCards.get(cardName);
		card.setCount(Integer.parseInt(count));

	}

	@RequestMapping(value = "removeCard/{cardName}", method = RequestMethod.DELETE)
	public String removeCard(@PathVariable("cardName") String cardName) {
		tallyCards.remove(cardName);
		return cardName + " removed.";

	}

	@RequestMapping(value = "removeAllCards", method = RequestMethod.GET)
	public String removeAllCards() {
		tallyCards.clear();
		return "all cards are removed.";

	}

	// helper methods
	public String getAllStringFromMap() {
		Iterator iterator = this.tallyCards.entrySet().iterator();
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
