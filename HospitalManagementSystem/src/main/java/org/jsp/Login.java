package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter out = resp.getWriter();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem", "root",
					"rootroot");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email=?");

			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String dbPassword = resultSet.getString("password");
				if (dbPassword.equals(password)) {
					// Moves to HomePage
					RequestDispatcher dispatcher = req.getRequestDispatcher("homepage");// php,html,jsp,servlet
					dispatcher.forward(req, resp);
				} else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
					out.println("<h1>Invalid Password</h1>");
					dispatcher.include(req, resp);
				}
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				out.println("<h1>Invalid Email</h1>");
				dispatcher.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
