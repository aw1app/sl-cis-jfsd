package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/S1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("INSIDE S1");
		
		PrintWriter out = response.getWriter();
		out.append("output 1 from servlet 1");
		
		response.sendRedirect(request.getContextPath()+"/S2");
		
		// This will never go to the browser.
		out.append("output 2 from servlet 1");
		
		out.close();
		
	}

}
