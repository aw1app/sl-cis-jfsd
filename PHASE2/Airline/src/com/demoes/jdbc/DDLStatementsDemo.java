package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLStatementsDemo {

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
		}
		;

		// Create a database
		try {
//			stmt.execute("CREATE DATABASE TESTDB");			
//			System.out.println("Successfully created database");
			
			stmt.execute("CREATE TABLE TESTDB.TEST_TABLE(name varchar(40))");			
			System.out.println("Successfully created table ");
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
