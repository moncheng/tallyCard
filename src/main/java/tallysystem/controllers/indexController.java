package tallysystem.controllers;

import java.util.HashMap;
import java.util.Iterator;

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
		String returnText="";
		if(!tallyCards.containsKey(cardName))
		{
			TallyCard card = new TallyCard(cardName);
		    tallyCards.put(cardName,card);
		    returnText=cardName+" added.";
		}
		else
		{
			returnText=cardName+" already exist, adding count.\n"+addCount(cardName);
		}
		
		
		return returnText;

	}
	@RequestMapping(value="getCard/{cardName}",method=RequestMethod.GET)
	public String getCard(@PathVariable("cardName") String cardName)
	{
		TallyCard card=tallyCards.get(cardName);
		
		return card.toString();		
	}
	
	@RequestMapping(value="getAllCards",method=RequestMethod.GET)
	public String getAllCards()
	{
		return getAllStringFromMap();		
	}
	
	@RequestMapping(value="addCount/{cardName}",method=RequestMethod.GET)
	public String addCount(@PathVariable("cardName") String cardName)
	{
		TallyCard card=tallyCards.get(cardName);
		card.addCount();
		return cardName+"'s count increment by 1, now is : "+card.getCount();		
	}
	
	@RequestMapping(value="addCount/{cardName}/{count}",method=RequestMethod.GET)
	public String setCardCount(@PathVariable("cardName") String cardName,
							   @PathVariable("count") int count)
	{
		TallyCard card=tallyCards.get(cardName);
		card.setCount(count);
		return cardName+"'s count set to: "+card.getCount();		
	}
	
	@RequestMapping(value="removeCard/{cardName}",method=RequestMethod.GET)
	public String removeCard(@PathVariable("cardName") String cardName)
	{
		tallyCards.remove(cardName);
		return cardName+" removed.";
		
	}
	
	@RequestMapping(value="removeAllCards",method=RequestMethod.GET)
	public String removeAllCards()
	{
		tallyCards.clear();
		return "all cards are removed.";
		
	}
	
	
	//helper methods
	public String getAllStringFromMap()
	{
		Iterator iterator = this.tallyCards.entrySet().iterator();
		String text="";
		while(iterator.hasNext())
		{
			HashMap.Entry pair = (HashMap.Entry)iterator.next();
			text+=pair.getValue().toString()+"\n\n";
		}
		if (text=="")
			text="no cards found.";
		return text;
	}
	

}
