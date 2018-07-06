package com.MyLast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class MyThird
 */
@WebServlet("/MyThird")
public class MyThird extends HttpServlet{ 
    	private static final long serialVersionUID=1L;
    	
    	public MyThird() {
            super();
            // TODO Auto-generated constructor stub
        }


            public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
           
            
            	PreparedStatement  ps=null;
            	String[] userans=new String[5];
            	String[] correctans={"False","False","True","True","True"};
            	String dbans="",n="";
            	String name="";
            	String RNO="";
            	int  total=0;
            	try
            	{
            	
            	Class.forName("com.mysql.jdbc.Driver");
            	
            	
            	userans[0]=request.getParameter("group1");
            	userans[1]=request.getParameter("group2");
            	userans[2]=request.getParameter("group3");
            	userans[3]=request.getParameter("group4");
            	userans[4]=request.getParameter("group5");
            	name=request.getParameter("nam");
            	for(int i=0;i<=4;i++)
            	{
            	if(correctans[i].equals(userans[i]))
            	total+=2;
            	}
            	Connection Con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java" ,"root", "Aarthi@1one");
            	ps=Con.prepareStatement("update entry set jav = ? where lname = ?");
            	ps.setInt(1, total);
            	ps.setString(2, name);
               	ps.executeUpdate();
            	Con.close();
            	}
            	catch(Exception e)
            	{
            	out.println(e);
            	}
            	out.println("<b><center><h1>Anna University<br/><br/>"
            	+"<table border=2>"
            	+"<th>Marks</th>"
            	+"<th>Name</th>"
            	+"<tr><td>" + total +"</td><td>"+ name +"</td></tr>"
            	+"</table>"
            	+"</html>");

}
}