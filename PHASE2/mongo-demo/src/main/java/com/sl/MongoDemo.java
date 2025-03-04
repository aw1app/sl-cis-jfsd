package com.sl;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoDemo {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> usersCollection;

	public static void main(String[] args) {
		
		connectToMongoDB();
		
//		Document user = new Document("name", "Jasprit2").append("age", 35).append("email", "jassy@example.com")
//				.append("address", new Document("city", "New Jersey").append("country", "USA"))
//				.append("eduaction", "MBA");
//		
//		//usersCollection.insertOne(user);
		updateUser();
		
		readUsers();

	}
	
	private static void readUsers() {
		// Find all users
		System.out.println("\nAll users:");
		usersCollection.find().forEach(doc -> System.out.println(doc.toJson()));		
	}
	
	private static void updateUser() {
		// Update one user
		Bson filter = Filters.eq("name", "Jasprit2");
		Bson update = Updates.combine(Updates.set("age", 31), Updates.set("email", "abc@example.com"));

		usersCollection.updateOne(filter, update);
		System.out.println("User updated successfully.");

		// Update multiple users
//		Bson multiFilter = Filters.eq("age", 35);
//		Bson multiUpdate = Updates.inc("age", 100);
//
//		usersCollection.updateMany(multiFilter, multiUpdate);
//		System.out.println("Multiple users updated successfully.");
	}
	

	private static void connectToMongoDB() {
		// Connect to local MongoDB

		String localDBURL = "mongodb://localhost:27017";
		//String cloudAtlasURL = "mongodb+srv://atrain:nLOo4TaR1HW12e9N@cluster0.ixxay.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

		mongoClient = MongoClients.create(localDBURL);

		// Get database and collection
		database = mongoClient.getDatabase("mydatabase");
		usersCollection = database.getCollection("users-sl");

		System.out.println("Successfully connected to MongoDB.");
	}

}
