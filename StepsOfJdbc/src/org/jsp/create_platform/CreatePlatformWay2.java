package org.jsp.create_platform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePlatformWay2 {
	public static void main(String[] args) {
		try {
			//Step1 Load And register driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2 Establish connection
			String url="jdbc:mysql://localhost:3306/a16";
			String userName="root";
			String password="rootroot";
			Connection connection=DriverManager.getConnection(url, userName, password);
			
			//Step 3 Create Platform
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Sita");
			preparedStatement.setString(3, "sita@supergot.in");
			preparedStatement.setString(4, "Sita@Ram12345");
			
			
			
			
			//Step 4 Execute Statement
			preparedStatement.executeUpdate();
			
			
			
			System.out.println("Data Inserted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
