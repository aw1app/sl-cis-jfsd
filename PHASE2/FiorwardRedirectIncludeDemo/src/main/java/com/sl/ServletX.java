package com.sl;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/X")
public class ServletX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.append("output 1 from servlet X <br>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Y");
		dispatcher.include(request, response);
		
		out.append("output 2 from servlet X <br>");
		
		out.close();
		
	}

}
