package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display_all")
public class DisplayAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/library_management_system";
			String user = "root";
			String password = "rootroot";

			Connection connection = DriverManager.getConnection(url, user, password);
			String query = "SELECT * FROM books";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				do {
					int book_id = resultSet.getInt("id");
					String book_name = resultSet.getString("name");
					String book_author = resultSet.getString("author");
					int book_cost = resultSet.getInt("cost");
					int book_pages = resultSet.getInt("pages");

					String result = "Book[ Id : " + book_id + " ,Name : " + book_name + " ,Author : " + book_author
							+ " ,Cost : " + book_cost + " ,Pages : " + book_pages + "]";
//					out.println(
//							"<h4>" + result + "<a href='delete?id=" + book_id + "'><button>Delete</button></a> </h4>");
					out.println("<h4>" + result + "</h4>");
					out.println("<form action='delete' method='get'>" + "<input type='hidden' value=" + book_id
							+ " name='id'>" + "<button>Delete</button></form>");
				} while (resultSet.next());
			} else {
				out.println("<h1> Books Are not available at the movement try again later</h1>");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}

}
