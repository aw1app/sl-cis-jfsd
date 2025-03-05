package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Random random = new Random();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String sessIdStr = request.getParameter("sessIdStr");

		if (sessIdStr == null) {
			int newSessId = random.nextInt();
			
			out.println("<p>  <a href='Servlet2?sessIdStr=" + newSessId + "' >Go to Servlet 2 </a></p>"); 
		}else {
			out.println("<p>  <a href='Servlet2?sessIdStr=" + sessIdStr + "' >Go to Servlet 2  </a>");
		}
		
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
