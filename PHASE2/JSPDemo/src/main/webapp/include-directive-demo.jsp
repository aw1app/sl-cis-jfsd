<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<%@ include file="header.jsp"%>


	List of names of great people:
	<br>
	<%!String[] names = { "Sameer", "Shisir", "Prakash", "Suma", "Lara" };%>
	<br>
	<%
	for (int i = 0; i < names.length; i++) {
		out.println(names[i]);
	}
	%>

	<%@ include file="footer.jsp"%>
</body>
</html>