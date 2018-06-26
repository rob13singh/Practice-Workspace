package com.springMVC.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBConnection
 */
@WebServlet(name = "TestDBServlet", urlPatterns = { "/TestDBServlet" })
public class TestDBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBConnection() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="springstudent";
		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to DB" + jdbcurl);
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcurl,user,user);
			
			out.println("Connection done");
			
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
