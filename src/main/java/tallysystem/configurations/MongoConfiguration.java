package tallysystem.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class MongoConfiguration {

	final String MONGO_LOCAL_HOST = "localhost";
	final int MONGO_LOCAL_PORT = 27017;
	
	@Bean
	public MongoOperations mongoOperations(Mongo mongo, String dbName) {
		MongoOperations mongoOperations = new MongoTemplate(mongo, dbName);
		return mongoOperations;
	}
	
	@Bean
    public MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost(MONGO_LOCAL_HOST);
        mongo.setPort(MONGO_LOCAL_PORT);
        return mongo;
    }

	@Bean
	public String dbName() {
		return "tallysystem";
	}
	
    /*
	 * Use this post processor to translate any MongoExceptions thrown in @Repository annotated classes
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}




