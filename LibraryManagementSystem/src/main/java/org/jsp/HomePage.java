package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Hi...." + name + "</h1>");
		out.print("<a href='display_all'><button>Display All</button></h1>");
		out.print("</body>");
		out.print("</html>");
		
		
		
		
	}
}
