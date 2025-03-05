package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sl.entities.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
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
			out.println("<p>  <a href='Servlet' >Go to Servlet 2 </a>");
		} else {
			out.println(" Session found in the request.");
			
			// List all products in the cart
			List<Product> productsInTheCart = (List<Product>) session.getAttribute("products");
			
			for(Product prod : productsInTheCart) {
				out.println("<p>  Found a product in the cart " + prod.getName() + ", "+ prod.getPrice());
			};
			
			out.println("<p>  <a href='Servlet1' >Go to Servlet 1 </a>");
			out.println("<p>  <a href='Servlet2' >Go to Servlet 2 </a>");
		}

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
