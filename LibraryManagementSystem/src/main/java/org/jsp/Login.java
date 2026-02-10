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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrintWriter out = resp.getWriter();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
					"root", "rootroot");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM hr WHERE email=?");

			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String dbPassword = resultSet.getString("password");
				if (dbPassword.equals(password)) {
					// Moves to HomePage
					String name = resultSet.getString("name");
					RequestDispatcher dispatcher = req.getRequestDispatcher("homepage?name=" + name);// php,html,jsp,servlet
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
