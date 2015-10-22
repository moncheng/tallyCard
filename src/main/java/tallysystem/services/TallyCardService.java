package tallysystem.services;

import java.util.HashMap;

import tallysystem.models.TallyCard;

public class TallyCardService {
	
	
	
	
	public HashMap<String,TallyCard> makeCards()
	{
		HashMap<String,TallyCard> cards = new HashMap<String,TallyCard>();
		
		String[] skills={"Java","C","Python","C++","C#","Ruby","Rails",
				"AngularJS","Git","Javascript","Html","CSS","BootStrap",
				"Chef","Swift","Xcode","Android","MS-Office","Jenkins",
				"UnitTest","UI Test","Database","Jquery","NodeJS"};
		String[] companies={"GE","Google","MicroSoft","Apple","Tesla",
							"Walmart","Shell","StarBuck"};
		String[] typeLoc={"Home","Office","School"};
		String[] workFor={"Myself","Big Company","School","Govement"};
		String[] studyFor={"MidTerm Exam","Final Exam","Class"};//if = class, append skills with class
		String[] schools={"Princeton University","Harvard University","Yale University",
						   "Columbia University","Stanford University","MIT","UNO","LSU"};
		String[] countries={"United States","United Kindom","China","Japan","Korea","Canada"
							,"Russia","Mexico","Span","Vietnam","German"};
		String[] cities={"New York","Los Angelas","San Francisco","Orlando","New Orleans",
						 "Chicago","Bei Jing","Shang Hai","Tokyo"};
		String[] titles={"Leader","Restaurant Owner","Boss","Manager","Programmer","Designer"
						  ,"CEO","CIO","CFO","COO","CSO","Baker","Chef","Maker"};

		//all for work
		cards=addCardsToMap(cards,"Work for ",skills);
		cards=addCardsToMap(cards,"Work at ",typeLoc);
		cards=addCardsToMap(cards,"Learn ",skills);
		cards=addCardsToMap(cards,"Study for ",studyFor);
		cards=addCardsToMap(cards,"Study at ",schools);
		cards=addCardsToMap(cards,"Research on ",skills);
		cards=addCardsToMap(cards,"Live in ",countries);
		cards=addCardsToMap(cards,"Live in ",cities);
		cards=addCardsToMap(cards,"Become a ",titles);
		return cards;
		
	}
	
	public HashMap<String, TallyCard> addCardsToMap(HashMap< String,TallyCard> cards, String preText,String[] array)
	{
		
		for(String x:array)
		{
			String name = preText+x;
			TallyCard card = new TallyCard(name);
			cards.put(name, card);
		}
		return cards;           
	}

}
