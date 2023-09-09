package com.jsp.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
	String url = "jdbc:mysql://localhost:3306/Product_Management_System";
	String username = "root";
	String password = "root";
	
	
	Connection connection = null;
	public Connection getConnection() {
		
		try {
			//Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
}
