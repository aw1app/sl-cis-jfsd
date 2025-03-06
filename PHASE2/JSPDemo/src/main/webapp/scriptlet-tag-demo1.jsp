<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<%!String[] names = { "Sameer", "Shisir", "Prakash", "Suma", "Lara" };%>

	<h3>Approach 1:</h3>
	Attendees today:
	<br>
	<%
	for (int i = 0; i < names.length; i++) {
		out.println(names[i]);
	}
	%>

	<h3>Approach 2:</h3>
	Attendees today:
	<br>
	<ol>
	<%
	for (int i = 0; i < names.length; i++) {
	%>
	
	<li> <%=names[i]%>
	
	<%
	}
	%>
	</ol>


</body>


</html>