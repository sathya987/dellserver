package com.library.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("asdfghj");

		try {
			String url = "jdbc:mysql://localhost/bece67_db";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "3306");
			PreparedStatement pst = con
					.prepareStatement(" select * from abc where username=? and password=? ");
			
			System.out.println("query excute");
			pst.setString(1, request.getParameter("username"));
		    pst.setString(2, request.getParameter("password"));
		//	String username = request.getParameter("username");
		//	String password = request.getParameter("password");


			ResultSet rs = pst.executeQuery();
			//System.out.println(rs.getFetchSize());
			/*if (rs.next()) {
				out.println("user and password is correct");
			} else {
				out.println("user and password is  not correct");
			}*/
			
			if(rs.next())
			{
				RequestDispatcher req=request.getRequestDispatcher("userinforamation.jsp");
				req.include(request, response);		
			System.out.println("if execuet part");
			}else
			{
				RequestDispatcher req=request.getRequestDispatcher("Logout.jsp");
				req.forward(request, response);
				System.out.println("else excute");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
