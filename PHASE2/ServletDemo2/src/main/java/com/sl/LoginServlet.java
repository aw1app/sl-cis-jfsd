package com.sl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		String[] educations = request.getParameterValues("education");
		
		if(uname.equalsIgnoreCase("admin") && passwd.equals("abc123")) {
		
		out.println("You have succesfully logged in. Welcome Admin.");
		}
		else {
			out.println("Incorredct credentials. Login failed!!");
		}
		
		out.println("Your Education is "+ Arrays.toString(educations));
		
		
		
		out.close();
		
	}

	
	

}
