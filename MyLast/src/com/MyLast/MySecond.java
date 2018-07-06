package com.MyLast;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

/**
 * Servlet implementation class MySecond
 */
@WebServlet("/MySecond")
public class MySecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySecond() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
		 
	        PrintWriter out = resp.getWriter();
	        
			String ab=req.getParameter("lnames");
			String cd=req.getParameter("pwds");
			String sam;
			String gear;
			
			HttpSession session = req.getSession();
			RequestDispatcher rd = null;
			RequestDispatcher rd2=null;
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" ,"root","Aarthi@1one");   
			Statement st = con.createStatement(); 
			String s="SELECT * from entry WHERE lname ='" + ab +"'";
			ResultSet rs=st.executeQuery(s);
			while (rs.next())
			 
			 {
				
				  sam=rs.getString("lname");
				  gear=rs.getString("pwd");
			 
		
			 
			if(sam.equals(ab) && gear.equals(cd))
				 	{
				session.setAttribute("user", ab);
				
				out.println("<html><font color=\"white\">LoginSuccessful</font></html>");
				rd = req.getRequestDispatcher("/uploads.html");
				rd.forward(req, resp);
				 		
				 	}
				 	else
				 	{
				 		session.setAttribute("errorMessage", "Error! Invalid Username or Password..");
					session.setAttribute("tryAgain", "Please Try Again..");
				 		out.println("<html><font color=\"white\">LoginUnsuccessful</font></html>");
				 		rd2 = req.getRequestDispatcher("/pass.html");
				    	rd2.forward(req, resp);
						//resp.sendRedirect("/WEB-INF/pass.html");
						//ServletContext sc = getServletContext();
						//sc.getRequestDispatcher("/pass.html").forward(req, resp);
			 }
			}
			con.close();  
			 
			 }catch(Exception e){ System.out.println(e);}  
		
	}
}