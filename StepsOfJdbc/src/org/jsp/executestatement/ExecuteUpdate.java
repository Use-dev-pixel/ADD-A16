package org.jsp.executestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate {
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
			Statement statement=connection.createStatement();

			//Step 4
//			String sql="CREATE TABLE Dept(id int(10) primary key, name varchar(50) ,email varchar(50) unique,password varchar(50) not null)";
//			statement.executeUpdate(sql);
//			System.out.println("Table Created");
			
//			String sql="INSERT INTO users VALUES(2,'Ram','ram@god.com','Sita@nlySita')";
			String sql="UPDATE users set password='sita@12345' where id=2";
			System.out.println(statement.executeUpdate(sql));
			System.out.println("Value Inserted");
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
