package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Addition extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long num1 = Long.parseLong(req.getParameter("num1"));
		long num2 = Long.parseLong(req.getParameter("num2"));
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		long sum = num1 + num2;
		out.println("<h2> Addiditon is : " + (sum) + " </h2>");
		
		out.println("<form action='square' method='get'>"
				+ "<input type='hidden' value="+sum+" name='sum'>"
						+ "<button> Square " + sum + "</button>" 
				+ "</form> ");
		out.println("</body>");
		out.println("</html>");
	}
}
