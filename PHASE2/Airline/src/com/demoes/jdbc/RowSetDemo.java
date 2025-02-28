package com.demoes.jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

	// Database connection details
	private static final String URL = "jdbc:mysql://localhost:3306/estore";
	private static final String USER = "root";
	private static final String PASSWORD = "rootroot";

	public static void main(String[] args) {

		try {
			RowSetFactory factory = RowSetProvider.newFactory();

			try (CachedRowSet rowSet = factory.createCachedRowSet()) {

				// Initial data load
				loadInitialData(rowSet);
				
				 System.out.println("Initial product data:");
				
				 printRowSet(rowSet);
				 

			}

		} catch (SQLException e) {
			System.err.printf("Caught exception : %s \n", e.getCause());
		}

	}

	private static void printRowSet(CachedRowSet rowSet) throws SQLException {
		 // Print column headers
        System.out.printf("%-4s  %-20s  %12s  %-15s%n", "ID", "Name", "Price", "Category");
        System.out.println("-".repeat(55));
        
        while (rowSet.next()) {
            
                System.out.printf("%-4d  %-20s  %,12.2f  %-15s%n",
                    rowSet.getInt("id"),
                    rowSet.getString("name"),
                    rowSet.getDouble("price"),
                    rowSet.getString("category")
                );
            
        }
		
	}

	private static void loadInitialData(CachedRowSet rowSet) throws SQLException {
		rowSet.setUrl(URL);
		rowSet.setUsername(USER);
		rowSet.setPassword(PASSWORD);
		rowSet.setCommand("SELECT * FROM products ORDER BY id");
		rowSet.execute();
	}

}
