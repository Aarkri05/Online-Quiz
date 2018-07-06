package com.MyLast;

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

/**
 * Servlet implementation class MyLastServlet
 */
@WebServlet("/MyLastServlet")
public class MyLastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLastServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
		 resp.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = resp.getWriter();
			String ab=req.getParameter("first");
			String cd=req.getParameter("last");
			String ef=req.getParameter("pass");
			String gh=req.getParameter("mail");
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" ,"root","Aarthi@1one");   
			PreparedStatement ps=con.prepareStatement("insert into entry(fname,lname,pwd,mid) values(?, ?, ?, ?)");  
			
			 
			ps.setString(1, ab);
	        ps.setString(2, cd);
	        ps.setString(3, ef);
	        ps.setString(4, gh);
	        int i=ps.executeUpdate();
			//System.out.println(i);
	        /*
			 * while(rs.next())  
			 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  */
				
	        if(i>0)
	          {
	        	
	            out.println("<html><font color=\"white\">You are sucessfully registered</font></html>");
	          }
	        
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
	}
}
