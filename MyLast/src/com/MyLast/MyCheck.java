package com.MyLast;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyCheck
 */
@WebServlet(urlPatterns = { "/logout","/MyCheck"})
public class MyCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String applicationContextPath = request.getContextPath();
		String ab = request.getParameter("lnames");
		String pad = request.getParameter("pwds");
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/uploads.html");
		session.setAttribute("errorMessage", "Error! Invalid Username or Password..");
		session.setAttribute("tryAgain", "Please Try Again..");
int i=0;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" ,"root","Aarthi@1one");   
			Statement st = con.createStatement(); 
			String s="SELECT * from entry WHERE lname ='" +ab+"' ";
			ResultSet rs=st.executeQuery(s);
			
			while (rs.next()) {
				i = 1;
			}
			if (i != 0) {
				session.setAttribute("user", ab);
				rd = request.getRequestDispatcher("/sample.html");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("/samp.jsp");
			    session.setAttribute("errorMessage", " Invalid username");
			    session.setAttribute("tryAgain", " please try again");
				rd.forward(request, response);
			}
			
			if (request.getRequestURI().equals(applicationContextPath + "/logout")) {
				request.getSession().invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sample.html");
				dispatcher.forward(request, response);
			}
			con.close();
		} catch (SQLException sqe) {
			System.out.println("Error : While Fetching records from database");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	



	}

}
