package org.jsp.singletonJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonJdbc {

	private static Connection connection;// null

	private SingletonJdbc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/a16";
			String userName = "root";
			String password = "rootroot";
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			new SingletonJdbc();
		}
		return connection;
	}
}
