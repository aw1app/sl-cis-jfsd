<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP decl demo</title>
</head>
<body>

<h2>JSP decl tag demo</h2>

<%!
int x=100;
String name="Mohan";
%>


x = <%=x %>

<br><br>

name = <%=name %>


</body>
</html>