<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">

<body>
	<h1>JSTL Demo</h1>
	
	<c:set var="x" value="100" />
	<c:out value="${x}" />
	
	<c:set var="items" value="apple,mango" />
	
	<ul>
		<c:forEach var="item" items="${items}">
			<li>${item}</li>
		</c:forEach>
	</ul>

	
</body>
</html>
