package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/LCServlet")
public class LCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) {
		System.out.println("Inside init()");
		
		String myVar1 = config.getInitParameter("var1");
		System.out.println("myVar1 = "+ myVar1);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("INSIDE doGet");

		PrintWriter out = response.getWriter();
		out.append("output 1 from LC servlet  <br>");
		
		// accessing context params from the web.xml
		String dbURL = request.getServletContext().getInitParameter("DBURL");
		out.append("output 2 from LC servlet  dbURL = " + dbURL);
		
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		System.out.println("Inside doPost");

		out.close();
	}
	
	public void destroy() {
		System.out.println("Inside destroy() ");
	}
	
	

}
