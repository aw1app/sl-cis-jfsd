package com.demoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FilteredRowSetdemo {

	private static final String URL = "jdbc:mysql://localhost:3306/estore";
	private static final String USER = "root";
	private static final String PASSWORD = "rootroot";

	public static void main(String[] args) {

		// First, let's create a sample table and insert some data
		try {
			createSampleData();

			demonstrateFilteredRowSet();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static void demonstrateFilteredRowSet() throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();

		// Create CachedRowSet instance
		try (FilteredRowSet filteredRowSet = factory.createFilteredRowSet()) {

			// Configure and execute query
			filteredRowSet.setUrl(URL);
			filteredRowSet.setUsername(USER);
			filteredRowSet.setPassword(PASSWORD);
			filteredRowSet.setCommand("SELECT * FROM employees");
			filteredRowSet.execute();
			
			System.out.println("Initial data:");
			printRowSet(filteredRowSet);

			// Create and apply a salary filter
			filteredRowSet.beforeFirst();
			SalaryFilter salaryFilter = new SalaryFilter(70000.0);
			filteredRowSet.setFilter(salaryFilter);

			System.out.println("SalaryFilter applied. Employees with salary > 70000:");
			printRowSet(filteredRowSet);
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
					  ( 'Sujata','HR',60000.0),
					  ( 'Sujata2','HR',100040.0),
					  ( 'Sujata3','FINANCE',50000.0),
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

class SalaryFilter implements Predicate {
	private double minSalary;

	public SalaryFilter(double minSalary) {
		this.minSalary = minSalary;
	}

	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getDouble("salary") > minSalary;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		return false;
	}
}
