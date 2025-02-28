package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetDemo {

	// Database connection parameters
	private static final String URL = "jdbc:mysql://localhost:3306/estore";
	private static final String USER = "root";
	private static final String PASSWORD = "rootroot";

	public static void main(String[] args) {

		try {
			// First, let's create a sample table and insert some data
			createSampleData();

			// Demonstrate CacheRowSet operations
			demonstrateCacheRowSet();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void demonstrateCacheRowSet() throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();

		// Create CachedRowSet instance
		try (CachedRowSet crs = factory.createCachedRowSet()) {
			// Configure the CachedRowSet
			crs.setUrl(URL);
			crs.setUsername(USER);
			crs.setPassword(PASSWORD);

			// Execute a query
			crs.setCommand("SELECT * FROM employees");
			crs.execute();

			System.out.println("Initial data:");
			printRowSet(crs);

			// Demonstrate offline operations
			// 1. Insert a new row
			crs.moveToInsertRow();
			crs.updateInt("id", 5);
			crs.updateString("name", "Sujata5");
			crs.updateString("department", "Finance");
			crs.updateDouble("salary", 70000.00);
			crs.insertRow();
			crs.moveToCurrentRow();

			System.out.println("Inserted new row. Fresh data is:");
			crs.beforeFirst();
			printRowSet(crs);

			Connection conn = getConnection();
			conn.setAutoCommit(false);
			// Synchronize changes with the database
			crs.acceptChanges(conn);
			conn.commit();

			System.out.println("Check the data in the database, sync up would have happened now");

			// 2. Update a existing row
			crs.beforeFirst();
			while (crs.next()) {
				if (crs.getInt("id") == 2) {
					crs.updateString("department", "Marketing");
					crs.updateRow();
					break;
				}

			}

			conn = getConnection();
			conn.setAutoCommit(false);
			crs.acceptChanges(conn);
			conn.commit();
			
			System.out.println("Check the data in the database, sync up would have happened now doe id=2");
			System.out.println("In the local CRS");
			printRowSet(crs);
			
			crs.absolute(4);
			crs.updateString("department", "EDUCATION");
			crs.updateRow();
			System.out.println("In the local CRS");
			crs.beforeFirst();
			printRowSet(crs);
			
			conn = getConnection();
			conn.setAutoCommit(false);
			crs.acceptChanges(conn);
			conn.commit();
			
			// Delete
			crs.absolute(1);
			crs.deleteRow();
			System.out.println("In the local CRS after deleting first row");
			crs.beforeFirst();
			printRowSet(crs);
			
			conn = getConnection();
			conn.setAutoCommit(false);
			crs.acceptChanges(conn);
			conn.commit();
			
			System.out.println("Check database, sync up would have happened now  id=1 "
					+ "row should now longer exist");		
			
		}

	}

	private static void createSampleData() throws SQLException {
		try (Connection conn = getConnection()) {
			var statement = conn.createStatement();

			// Drop table if exists and create new one
			statement.execute("DROP TABLE IF EXISTS employees");
			statement.execute("""
					    CREATE TABLE employees (
					        id INT PRIMARY KEY AUTO_INCREMENT,
					        name VARCHAR(100),
					        department VARCHAR(50),
					        salary DECIMAL(10,2)
					    )
					""");

			// Insert sample data
			statement.execute("""
					  INSERT INTO employees (name, department, salary) VALUES
					  ( 'Sujata','HR',100000.0),
					  ( 'Sujata2','HR',100040.0),
					  ( 'Sujata3','FINANCE',120000.0),
					  ( 'Sujata4','HR',105000.0)
					""");

		}
	}

	private static void printRowSet(CachedRowSet crs) throws SQLException {
		// Print column headers
		System.out.println("ID\tName\t\tDepartment\tSalary");
		System.out.println("-".repeat(50));

		// Print data
		while (crs.next()) {
			System.out.printf("%d\t%-15s\t%-10s\t%.2f%n", crs.getInt("id"), crs.getString("name"),
					crs.getString("department"), crs.getDouble("salary"));
		}
	}

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
