package com.sl.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(servletNames = { "VotingServlet" })
public class VotingFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);

		System.out.println("INSIDE VotingFilter age =" + age);
		if (age < 18) {
			out.println("You are not eligible to vote!");
			System.out.println("INSIDE VotingFilter age =" + age);
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

		out.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
