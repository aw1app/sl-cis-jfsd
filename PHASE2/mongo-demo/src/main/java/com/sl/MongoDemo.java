package com.sl;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDemo {

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> usersCollection;

	public static void main(String[] args) {
		
		connectToMongoDB();
		
		Document user = new Document("name", "Jasprit").append("age", 30).append("email", "jassy@example.com")
				.append("address", new Document("city", "New York").append("country", "USA"))
				.append("hobbies", Arrays.asList("reading", "swimming"));
		
		usersCollection.insertOne(user);
		
		readUsers();

	}
	
	private static void readUsers() {
		// Find all users
		System.out.println("\nAll users:");
		usersCollection.find().forEach(doc -> System.out.println(doc.toJson()));		
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
