package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");

		long number = Long.parseLong(req.getParameter("number"));
//		String number=req.getParameter("number");
//		long mobileNumber=Long.parseLong(number);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem", "root",
					"rootroot");
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setLong(4, number);
			
			int result=preparedStatement.executeUpdate();
			
			
			PrintWriter out= resp.getWriter();
			
			
			if (result==1) {
				out.println("<h1>Signup Successful</h1>");
			} else {
				out.println("<h1>Signup UnSuccessful</h1>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
