package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MongoServlet")
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> usersCollection;

	public void init(ServletConfig config) {

		ServletContext sc = config.getServletContext();

		String localMongoURL = sc.getInitParameter("DBURL");

		mongoClient = MongoClients.create(localMongoURL);

		// Get database and collection
		database = mongoClient.getDatabase("mydatabase");
		usersCollection = database.getCollection("users-sl");

		System.out.println("Successfully connected to MongoDB.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// Find all users
		System.out.println("\nAll users:");
		usersCollection.find().forEach(doc -> out.println(doc.toJson() + "<p><br>"));
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
