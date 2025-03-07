<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<body>
	<h1>JSTL Demo</h1>

	<c:set var="x" value="100" />
	<c:out value="${x}" />

	<!-- Decl an array -->
	<c:set var="items" value="apple,mango" />

	<!-- Looping into an array -->
	<h2>Looping into an array without a counter just like we loop a
		ArrayList</h2>
	<ul>
		<c:forEach var="item" items="${items}">
			<li>${item}</li>
		</c:forEach>
	</ul>

	<!-- Looping into an array using a counter -->
	<h2>Looping into an array using a counter</h2>
	<c:forEach var="j" begin="1" end="5" step="2">
 		Item <c:out value="${j}" />
		<p>
	</c:forEach>

	<!-- Looping into a tokenized string -->
	<h2>Looping into a tokenized string. String is "Jack-Lynda-Rose" .</h2>
	<c:forTokens items="Jack-Lynda-Rose" delims="-" var="name">
		<c:out value="${name}" />
		<p>
	</c:forTokens>


	<%
	session.setAttribute("user", "jack");
	%>

	Value is ${ sessionScope.user }


	<!-- Conditional statement tage demo -->
	<c:if test="${sessionScope.user.equals(\"jack\")}">
	Yes the name was Jack
	</c:if>

	<!-- 	c:redirect url="http://google.com" />-->

	<!-- c:choose demo -->
	<c:set var="userRole" value="editor" />

	<c:choose>

		<c:when test="${userRole == 'admin'}">
			<p>Welcome, Admin! You have full access.</p>
		</c:when>

		<c:when test="${userRole == 'editor'}">
			<p>Welcome, Editor! You have editor access.</p>
		</c:when>

		<c:otherwise>
			<p>Welcome, Viewer! You can only view content.</p>
		</c:otherwise>

	</c:choose>

	<br>
	<br>
	<p>
		ADVANCED examples <br> 
		<a href="jstl-catch-demo.jsp">Catch Demo</a>
		<a href="URLParamTagDemo.jsp">URL Param Demo</a>
		
</body>
</html>
