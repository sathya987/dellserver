package com.library.home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterClass
 */
@WebServlet("/RegisterClass")
public class RegisterClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try
{
	

	String url = "jdbc:mysql://localhost/bece67_db";
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection(url, "root", "3306");
	PreparedStatement pst = con
			.prepareStatement(" insert into abc values(?,?,?,?,?,?) ");
	System.out.println("query excution----------------");
		response.setContentType("text/html");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		pst.setString(1, first_name);
		pst.setString(2, last_name);
		pst.setString(3, username);
		pst.setString(4, password);
		pst.setString(5, address);
		pst.setString(6,contact);
	pst.executeUpdate();
		System.out.println("excuted query");

		if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty()
				|| password.isEmpty() || address.isEmpty() || contact.isEmpty()) {
			RequestDispatcher req = request
					.getRequestDispatcher("register.jsp");
			req.include(request, response);
		} else {
			RequestDispatcher req = request
					.getRequestDispatcher("home.jsp");
			req.forward(request, response);

	
		}
	
}catch(Exception e)
{
	e.printStackTrace();
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
