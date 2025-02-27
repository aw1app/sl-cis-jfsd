package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class PreparedStatementBatchDemo {

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
			preparedStmt.setString(1, "Tata Car 15");
			preparedStmt.setDouble(2, 10000015.00d);
			preparedStmt.setString(3, "Automobile");

			preparedStmt.addBatch();

			preparedStmt.setString(1, "Tata Car 16");
			preparedStmt.setDouble(2, 10000016.00d);
			preparedStmt.setString(3, "Automobile");

			preparedStmt.addBatch();

			preparedStmt.setString(1, "Tata Car 17");
			preparedStmt.setDouble(2, 10000017.00d);
			preparedStmt.setString(3, "Automobile");

			preparedStmt.addBatch();

			int[] results = preparedStmt.executeBatch();

			System.out.println(Arrays.toString(results));

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
