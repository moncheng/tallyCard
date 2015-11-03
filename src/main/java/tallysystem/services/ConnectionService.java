package tallysystem.services;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnectionService {
	
	public void connectMongo(String host, int port) throws UnknownHostException
	{
		MongoClient mongo= new MongoClient(host,port);
	}
	
	public DB getDatabase(MongoClient mongo,String dbName)
	{
		return mongo.getDB(dbName);
	}

}



