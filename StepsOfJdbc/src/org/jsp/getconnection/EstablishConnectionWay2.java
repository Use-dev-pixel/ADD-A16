package org.jsp.getconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnectionWay2 {
	public static void main(String[] args) {
		try {
			// Step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2
			String url = "jdbc:mysql://localhost:3306/a16";
			String userName = "root";
			String password = "rootroot";
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
