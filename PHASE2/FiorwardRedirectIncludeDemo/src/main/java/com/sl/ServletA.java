package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/A")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.append("output 1 from servlet A");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/B");
		dispatcher.forward(request, response);
		
		out.append("output 2 from servlet A");
		
		out.close();
		
	}

}
