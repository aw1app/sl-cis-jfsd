package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQueryDemo {

	public static void main(String[] args) {

		// Step1 : Load the driver.
//		try {
//			Class.forName("DriverManager.class");
//		} catch (ClassNotFoundException e) {			
//			e.printStackTrace();
//		}
		// Above step is not needed for our Java versions

		Connection connection = null;
		Statement stmt = null;

		// Step 2: Create a Connection object.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.
			stmt = connection.createStatement();

		} catch (SQLException e) {
			System.err.println(e);
		}
		;

		// Step 4: Execute the SQL command.
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM products");

			// Step 5: Extract the results and display
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String category = rs.getString("category");

				//System.out.println("id=" + id + ", Name=" + name + ", Price=" + price + ", Category=" + category);
				System.out.printf("id=%s \t Name=%s \t Price=%s \t Category=%s \t \n",id,name,price, category  );
			}

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
