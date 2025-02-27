package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStmt = null;

		// Step 2: Create a Connection object.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.
			String sqlStr = "INSERT INTO products (name, price, category) VALUES (? ,?, ? )";
			preparedStmt = connection.prepareStatement(sqlStr);

		} catch (SQLException e) {
			System.err.println(e);
		}
		;
		
		// Step 4: 
		try {
			preparedStmt.setString(1, "Toyota Car");
			preparedStmt.setDouble(2, 10000000.00d);
			preparedStmt.setString(3, "Automobile");
			
			int count = preparedStmt.executeUpdate();
			System.out.printf("Inserted %s number of rows \n", count);
			
			preparedStmt.clearParameters();
			
		} catch (SQLException e) {
			System.out.println(e);
		}

		// Clean up
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
