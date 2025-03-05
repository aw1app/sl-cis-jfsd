package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Random random = new Random();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String sessIdStr = request.getParameter("sessIdStr");

		if (sessIdStr != null) {

			out.println("Welcome User. I think you already visted other pages on this site then have come to me. ");
			out.println("<br> We are tracking you.");

		} else {
			out.println("Welcome User. Looks like you are visting this website for first time.");

			int newSessId = random.nextInt();
			out.println("<br> <br> <a href='Servlet1?sessIdStr=\" + sessIdStr + \"' >Go to Servlet 1</a>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
