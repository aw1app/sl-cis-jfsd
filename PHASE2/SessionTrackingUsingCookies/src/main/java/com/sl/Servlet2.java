package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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

		Cookie[] cookies = request.getCookies();

		boolean sessionIdCookieFound = false;
		String sessIdStr = null;

		if(cookies!=null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("sessIdStr")) {
				sessIdStr = cookie.getValue();
				sessionIdCookieFound = true;

				out.println("<p> SERVLET 2: Found the session id cookie in this request " + sessIdStr);
				break;
			}
		}
		}

		if (sessionIdCookieFound == false) {
			out.println("<p> SERVLET 2:  No session id cookie was found in this request. So creating one to start tracking");

			Cookie cookie = new Cookie("sessIdStr", random.nextInt() + "");
			response.addCookie(cookie);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
