package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// .getSession(true) true means create a new session object if a http session
		// object was never created for this user
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			out.println(" No session found in the request. Creating one to track the user ");
			session = request.getSession(true);
			out.println("<p>  <a href='Servlet2' >Go to Servlet 2 </a>");
		}else {
			out.println(" Session found in the request.");
			out.println("<p>  <a href='Servlet2' >Go to Servlet 2 </a>");
		}
		
		

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
