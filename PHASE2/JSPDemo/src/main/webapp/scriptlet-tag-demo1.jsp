<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>

Date : <%=new Date() %>

<body>
	<%!String[] names = { "Sameer", "Shisir", "Prakash", "Suma", "Lara" };%>

	<h3>Approach 1 (using built-in out object within scriptlet block to print something):</h3>
	Attendees today:
	<br>
	<%
	for (int i = 0; i < names.length; i++) {
		out.println(names[i]);
	}
	%>

	<h3>Approach 2 using expression tag within/outside scriptlet block to print something):</h3>
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