package tallysystem.controllers;

import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tallysystem.models.TallyCard;

@RestController
@RequestMapping(value="/")
public class indexController {
	
	//mock data
	private Map<String,TallyCard> tallyCards;	
	
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
	
	@RequestMapping(value="getAllCard",method=RequestMethod.GET)
	public String getAllCard()
	{
		return getAllCard();		
	}
	
	@RequestMapping(value="addCount/{cardName}",method=RequestMethod.GET)
	public String incrementCardCount(@PathVariable("cardName") String cardName)
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
	
	
	//helper methods
	public String getAllStringFromMap()
	{
		Iterator iterator = this.tallyCards.entrySet().iterator();
		String text="";
		while(iterator.hasNext())
		{
			Map.Entry pair = (Map.Entry)iterator.next();
			text+=pair.toString()+"\n";
			iterator.remove();
		}
		return text;
	}
	

}
