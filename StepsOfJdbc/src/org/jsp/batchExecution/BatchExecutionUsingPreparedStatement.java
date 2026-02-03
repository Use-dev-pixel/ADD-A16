package org.jsp.batchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecutionUsingPreparedStatement {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/a16";
		String userName = "root";
		String password = "rootroot";

		try (Connection connection = DriverManager.getConnection(url, userName, password);
				PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			statement.setInt(1, 101);
			statement.setString(2, "Krishna");
			statement.setString(3, "Krishna@god.co.in");
			statement.setString(4, "Gopias@12345");
			statement.setLong(5, 1000000L);
			
			statement.addBatch();
			
			
			
			statement.setInt(1, 102);
			statement.setString(2, "MahaDev");
			statement.setString(3, "mahadev@god.co.in");
			statement.setString(4, "maha@parvathi");
			statement.setLong(5, 10000000L);
			
			statement.addBatch();

			int[] result = statement.executeBatch();
			System.out.println(Arrays.toString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
