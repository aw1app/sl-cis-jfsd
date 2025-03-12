<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />

<!-- Hard Code validation for now  -->
<!-- Ideally connect to the database and do the the validation  -->
<%
if (request.getParameter("username").equals("admin") && request.getParameter("password").equals("adminadmin")) {
	session.setAttribute("loggedin", "true");
	out.println("Login successfull!");
} else {
	out.println("Invalid username / password!");
	out.println("<a href='login-form.jsp' > GO BACK TO LOGIN </a>");
}
%>