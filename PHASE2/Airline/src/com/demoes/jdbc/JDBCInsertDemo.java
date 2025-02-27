package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertDemo {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;

		// Step 2: Create a Connection object.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.
			stmt = connection.createStatement();

		} catch (SQLException e) {
			System.err.println(e);
		};
		
		
		// Step 4: Execute the SQL command.
		String sqlStr = "INSERT INTO products (name, price, category) VALUES ('Maruti Car' ,500000.0, 'Automobile' )";
		try {
			int count = stmt.executeUpdate(sqlStr);
			
			System.out.printf("Inserted %s number of rows \n", count);
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
