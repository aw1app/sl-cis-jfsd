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
		response.setContentType("text/html");
		
		String sessIdStr = request.getParameter("sessIdStr");

		if (sessIdStr == null) {
			int newSessId = random.nextInt();
			out.println(" No session id found in the request. Creating one to track the user " + newSessId);
			
			out.println("<html><form action='Servlet2' method='POST'>");
			out.println("<input type='hidden' name='sessIdStr' value='" + newSessId + "'>");
			out.println("<input type='submit' value='submit' >");
			out.println("</form>");
			out.println("<script>document.forms[0].submit();</script></html>");
			

		} else {
			out.println(" Session id found in the request. " + sessIdStr);
			out.println("<p>  <a href='Servlet1?sessIdStr=" + sessIdStr + "' >Go to Servlet 1 </a>"); // Go to Servlet 2
																									// servlet
		}

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
