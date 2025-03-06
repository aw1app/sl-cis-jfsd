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

<!-- Decl block 1 -->
<%!
int a=100;
int b = 25; 
String name="Mohan";

public int sum(int x, int y){
	return x+y;
};
%>

<!-- Decl block 2 -->
<%! public int multiply(int x, int y){ return x*y;} %>

a = <%=a %>, b = <%=b %>,
<br><br>
a+b = <%=sum(a,b) %>
a * b = <%=multiply(a,b) %>

<br><br>
name = <%=name %>


</body>
</html>