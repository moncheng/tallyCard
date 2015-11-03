package tallysystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.Mongo;

@SpringBootApplication
@Configuration

public class TallySystemApplication {

	@Autowired
	private Mongo mongo;
	@Autowired
	private MongoOperations mongoOperations;
		
    public static void main(String[] args) {
        SpringApplication.run(TallySystemApplication.class, args);
    }
    
    
    
}
