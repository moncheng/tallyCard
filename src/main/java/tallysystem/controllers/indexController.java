package tallysystem.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tallysystem.models.TallyCard;

@RestController
@RequestMapping(value="/")
public class indexController {
	
	//mock data
	private HashMap<String,TallyCard> tallyCards= new HashMap<String,TallyCard>();	
	
	//end mock data
	
	
	@RequestMapping(value="newCard/{cardName}",method=RequestMethod.GET)
	public String createNewCard(@PathVariable("cardName") String cardName)
	{
		TallyCard card = new TallyCard(cardName);
		tallyCards.put(cardName,card);
		return "complete";
		
	}
	
	@RequestMapping(value="addCount/{cardName}",method=RequestMethod.GET)
	public String incrementCardCount(@PathVariable("cardName") String cardName)
	{
		TallyCard card;
		card=tallyCards.get(cardName);
		return cardName;
		
	}
	
	
	
	
	//helper method
	
	

}
