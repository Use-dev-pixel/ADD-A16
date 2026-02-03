package org.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","rootroot");
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email=?");

		
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String dbPassword = resultSet.getString("password");
				if (dbPassword.equals(password)) {
					System.out.println("Login Successful");
				} else {
					throw new RuntimeException("Password Invalid");
				}
			} else {
				throw new RuntimeException("User Not Found With email : " + email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
