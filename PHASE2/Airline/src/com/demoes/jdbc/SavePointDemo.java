package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavePointDemo {

	public static void main(String[] args) {
		Connection connection = null;
		Savepoint savePoint1 = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			connection.setAutoCommit(false);

			String insertSQL = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertSQL);

			stmt.setString(1, "Dell Laptop 1");
			stmt.setDouble(2, 300000.07878787878d);
			stmt.setString(3, "Electronics");			

			stmt.executeUpdate();
			System.err.println("WARNINGS: " + stmt.getWarnings());

			// Create a SavePoint
			savePoint1 = connection.setSavepoint("Savepoint1");
			System.err.println("SavePoint 1 created successfully");

			stmt.setString(1, "Dell Laptop 2");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3,
					"Electronics QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");

			stmt.executeUpdate();

			stmt.setString(1, "Dell Laptop 3");
			stmt.setDouble(2, 3000.0d);
			stmt.setString(3, "Electronics");

			stmt.executeUpdate();

			connection.commit();

		} catch (SQLException e) {
			System.err.println("Something went wrong!");
			System.err.println(e.getMessage());
			System.err.println(e.getErrorCode());

			try {
				connection.rollback(savePoint1);
				connection.commit();
				
//				 connection.rollback();
				System.err.println("Rollback happened!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
