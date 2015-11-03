package tallysystem.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import tallysystem.models.TallyCard;

@Repository
public class TallyCardRepository {

	@Autowired
	private MongoOperations mongoOperations;
	
	public void saveCard(TallyCard card) {
		mongoOperations.save(card);
	}
	public void removeCard(Query query) {
		mongoOperations.findAndRemove(query, TallyCard.class);
	}
	public List<TallyCard> getCard(Query query) {
		return  mongoOperations.find(query, TallyCard.class);
	}
	public List<TallyCard> getAllCards() {
		List<TallyCard> cards=mongoOperations.findAll(TallyCard.class);
		System.out.println("------------------\n"+cards.isEmpty()+"\n----------------------");
		return cards;
	}
}
