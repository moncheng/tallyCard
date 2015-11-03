package tallysystem.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tallysystem.models.TallyCard;

@Service
public class TallyCardService {

	@Autowired
	private MongoOperations mongoOperations;

//	public void createCard(TallyCard card) {
//		 cardRepository.saveCard(card);
//	}
	public TallyCard getCardByName(String name) {
		Query query = createQuery("name", name);
		return getCard(query).get(0);
	}
	public void removeCardByName(String name){
		Query query = createQuery("name",name);
		removeCard(query);
	}

	public Query createQuery(String column, String name) {
		return new Query(Criteria.where(column).is(name));
	}
	
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
		return mongoOperations.findAll(TallyCard.class);

	}
	

}
