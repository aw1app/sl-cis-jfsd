<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<body>
	<h1>JSTL Demo</h1>

	<c:url value="/index1.jsp" var="completeURL" >
	<c:param name="trackingId" value="123" />
	<c:param name="user" value="jack" />
	</c:url>
	${completeURL}


	<br>
	<br>
	<a href="index.jsp">Index Page</a>
</body>
</html>
