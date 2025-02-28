package com.demoes.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementDemo {

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement callableStmt = null;

		// Step 2: Create a Connection object.
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root", "rootroot");

			// Step 3: Create a Statement object.
			String sqlStr = "{ call add_product(? ,?, ? ) }";
			callableStmt = connection.prepareCall(sqlStr);

		} catch (SQLException e) {
			System.err.println(e);
		};
		
		try {
			callableStmt.setString(1, "Tesla Car 4");
			callableStmt.setDouble(2, 10070005.00d);
			callableStmt.setString(3, "Automobile");
			
			
			int count = callableStmt.executeUpdate();
			
			
			
			System.out.printf("Through calling a SP, inserted %s number of rows \n", count);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		

	}

}
