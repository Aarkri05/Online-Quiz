package com.MyLast;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFifth
 */
@WebServlet("/MyFifth")
public class MyFifth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFifth() {
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
		PrintWriter out = response.getWriter();
		   
	    
    	PreparedStatement  ps=null;
    	
    
    	String names="";
    	String fnam="";
    	String lnam="";
    	    	String javs="";
    	    	String jss="";
    	int  total=0;
    	
    	
    	names=request.getParameter("name");
    	
    	try
    	{
       	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" ,"root", "Aarthi@1one");
    	Statement st = con.createStatement();
    	String s= "select fname,lname,jav,js from entry where lname = '" + names +"' ";
    	ResultSet res=st.executeQuery(s);
		while (res.next())
		{
			fnam = res.getString("fname"); 
			lnam = res.getString("lname");
			javs= res.getString("jav");
			jss=res.getString("js");
       	 
		}con.close();
    	
    	}
    	catch(Exception e)
    	{
    	out.println(e);
    	}
    	out.println("<b><center><h1>Anna University<br/><br/>"
    	+"<table border=2>"
    	+"<th>FirstName</th>"
    	+"<th>Lastname</th>"
    	+"<th>jav</th>"
    	+"<th>js</th>"
    	+"<tr><td>" + fnam +"</td> <td>"+ lnam +"</td> <td>"+ javs +"</td> <td>"+ jss +"</td></tr>"
    	+"</table>"
    	+"</html>");

}
}
