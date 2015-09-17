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
	@RequestMapping(value="getCard/{cardName}",method=RequestMethod.GET)
	public String getCard(@PathVariable("cardName") String cardName)
	{
		TallyCard card=tallyCards.get(cardName);
		
		return card.toString();		
	}
	
	@RequestMapping(value="addCount/{cardName}",method=RequestMethod.GET)
	public String incrementCardCount(@PathVariable("cardName") String cardName)
	{
		TallyCard card=tallyCards.get(cardName);
		card.addCount();
		return cardName+"'s count increment by 1, now is : "+card.getCount();
		
	}

	
	
	
	
	//helper method
	
	

}
