package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.sl.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// .getSession(true) true means create a new session object if a http session
		// object was never created for this user
		HttpSession session = request.getSession(false);

		if (session == null) {
			out.println(" No session found in the request. Creating one to track the user ");
			session = request.getSession(true);
			out.println("<p>  <a href='Servlet1' >Go to Servlet 1 </a>");
			out.println("<p>  <a href='CartServlet' >Go to CartServlet </a>");
		} else {
			out.println(" Session found in the request.");
			out.println("<p>  <a href='Servlet1' >Go to Servlet 1 </a>");
			out.println("<p>  <a href='CartServlet' >Go to CartServlet </a>");
		}
		
		// Create Products and add to the session.
		Product p1 = new Product("apple", 100);
		Product p2 = new Product("mango", 70);
		
		List<Product> products = new ArrayList<Product>() ;
		products.add(p1);
		products.add(p2);
		
		session.setAttribute("products", products);		

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
