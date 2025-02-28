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

				//rowSet.absolute(5);
				
				updateProductPrice(rowSet, "Tata Car 17", 1.0d);
				rowSet.acceptChanges();
				
				printRowSet(rowSet);
				

				//insertNewProduct(rowSet);

				//System.out.println("Product table data after insert a ROW AS Position 5:");

				

			}

		} catch (SQLException e) {
			System.err.printf("Caught exception : %s \n", e.getCause());
		}

	}

	private static void updateProductPrice(CachedRowSet rowSet, String productName, double newPrice)
			throws SQLException {
		
		rowSet.beforeFirst();
		
		while (rowSet.next()) {
			if (rowSet.getString("name").equals(productName)) {
				rowSet.updateDouble("price", newPrice);
				rowSet.updateRow();
				break;
			}
		}
	}

	private static void insertNewProduct(CachedRowSet rowSet) throws SQLException {
		// Save current position
		int currentRow = rowSet.getRow();

		try {
			rowSet.moveToInsertRow();
			rowSet.updateString("name", "Keyboard");
			rowSet.updateDouble("price", 45.00);
			rowSet.updateString("category", "Electronics");
			rowSet.insertRow();

			// Move back to previous position
			if (currentRow > 0) {
				rowSet.absolute(currentRow);
			} else {
				rowSet.beforeFirst();
			}
		} catch (SQLException e) {
			// If insert fails, ensure we restore position
			if (currentRow > 0) {
				rowSet.absolute(currentRow);
			} else {
				rowSet.beforeFirst();
			}
			throw new SQLException("Failed to insert new product: " + e.getMessage());
		}
	}

	private static void printRowSet(CachedRowSet rowSet) throws SQLException {
		// Print column headers
		System.out.printf("%-4s  %-20s  %12s  %-15s%n", "ID", "Name", "Price", "Category");
		System.out.println("-".repeat(55));

		while (rowSet.next()) {

			System.out.printf("%-4d  %-20s  %,12.2f  %-15s%n", rowSet.getInt("id"), rowSet.getString("name"),
					rowSet.getDouble("price"), rowSet.getString("category"));

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
