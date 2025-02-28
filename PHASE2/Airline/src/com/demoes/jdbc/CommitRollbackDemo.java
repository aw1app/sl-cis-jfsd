package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class CommitRollbackDemo {

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

		// Transaction Management
		try {
			connection.setAutoCommit(false);

			preparedStmt.setString(1, "Apple Laptop 4");
			preparedStmt.setDouble(2, 3010.0d);
			preparedStmt.setString(3, "Electronics");

			preparedStmt.addBatch();

			preparedStmt.setString(1, "Apple Laptop 5");
			preparedStmt.setDouble(2, 3000000000030.0d);
			preparedStmt.setString(3, "Electronics");

			preparedStmt.addBatch();

			preparedStmt.setString(1, "Apple Laptop 6");
			preparedStmt.setDouble(2, 3040.0d);
			preparedStmt.setString(3, "Electronics");

			preparedStmt.addBatch();

			int[] results = preparedStmt.executeBatch();

			connection.commit();

			System.out.println(Arrays.toString(results));

		} catch (SQLException e) {
			System.err.println(" Caught exception with message " + e.getMessage());
			System.err.println(" Caught exception with error code " + e.getErrorCode());

			try {
				connection.rollback();
				System.err.println(" Rolling back " + e.getErrorCode());
			} catch (SQLException e1) {
				System.err.println("Caught exception during Rolling back " + e.getErrorCode());
			}

		}

	}

}
