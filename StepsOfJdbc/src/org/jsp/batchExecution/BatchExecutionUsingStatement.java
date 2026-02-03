package org.jsp.batchExecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecutionUsingStatement {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/a16";
		String userName = "root";
		String password = "rootroot";

		try (Connection connection = DriverManager.getConnection(url, userName, password);
				Statement statement = connection.createStatement();) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String query1 = "UPDATE users SET salary=10000 WHERE salary = 1000";
			String query2 = "UPDATE users SET salary=200000 WHERE name = 'Ram'";
			String query3 = "DELETE FROM users WHERE name = 'Prem'";

			statement.addBatch(query1);
			statement.addBatch(query2);
			statement.addBatch(query3);

			int[] result = statement.executeBatch();
			System.out.println(Arrays.toString(result));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
