package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession();

		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String password = (String) session.getAttribute("password");
		long number = (Long) session.getAttribute("number");

		out.println("<h1>Profile</h1>");
		out.println("<form action='update' method='post'>");
		out.println("Name: <input type='text' value=" + name + " name='name'> <br>");
		out.println("Email: <input type='email' value=" + email + " name='email'><br>");
		out.println("Password: <input type='password' value=" + password + " name='password'><br>");
		out.println("Number: <input type='tel' value=" + number + " name='number'><br>");
		out.println("<button> Update</button>");
		out.println("</form>");
		out.println("<form action='homepage' method='post'>");
		out.println("<button> HomePage</button>");
		out.println("</form>");
		
		

	}
}
