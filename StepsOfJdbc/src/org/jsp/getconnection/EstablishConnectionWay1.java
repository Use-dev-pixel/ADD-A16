package org.jsp.getconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnectionWay1 {
	public static void main(String[] args) {
		try {
			//Step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2
			String url="jdbc:mysql://localhost:3306/a16?user=root&&password=rootroot";
			Connection connection=DriverManager.getConnection(url);
			System.out.println("Connection Successful"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
