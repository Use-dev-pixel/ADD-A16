package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");

		long number = Long.parseLong(req.getParameter("number"));
		
		
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		System.out.println(number);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
					"root", "rootroot");
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE hr SET name=?,email=?,password=?,number=? WHERE email=?");

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setLong(4, number);
			preparedStatement.setString(5, email);

			preparedStatement.executeUpdate();

			HttpSession session=req.getSession();
			session.setAttribute("name", name);
			
			
			resp.sendRedirect("profile");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
