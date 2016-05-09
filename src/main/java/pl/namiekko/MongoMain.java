package pl.namiekko;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class MongoMain {

	public static void mongoMain(String[] args) {

		//connect
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("test");

		//find all users
		FindIterable<Document> result = db.getCollection("users").find();		

		//get first result
		Document d = result.first();
		System.out.println(d);				

		//update the first document which matches pattern d
		db.getCollection("users").updateOne(d,
		        new Document("$set", new Document("user_name", "second")));
		
		//create index
		db.getCollection("users").createIndex(new Document("user_name", 1));		

		//disconnect
		mongoClient.close();

	}

}
