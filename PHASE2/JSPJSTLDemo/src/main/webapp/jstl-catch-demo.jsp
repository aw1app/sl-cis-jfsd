<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<body>
	<h1>JSTL Catch Demo</h1>

	<%-- Define variables --%>
	<c:set var="num1" value="10" />
	<c:set var="num2" value="0" />


	<c:catch var="exception">
		<c:set var="result" value="${10 / 0}" />
	</c:catch>

	<c:if test="${not empty exception}">
		<p style="color: red;">Error: ${exception.message}</p>
	</c:if>



	<h2>Handling Null Values</h2>
	<c:set var="text" value="${null}" />
	<c:catch var="nullExcn">
		<p>Length of text: ${fn:length(text.toUpperCase())}</p>
	</c:catch>

	<c:if test="${not empty nullExcn}">
		<p style="color: red;">Error: ${nullExcn.message}</p>
	</c:if>



	<c:catch var="exceptionReference">
		<%
		int x = 2 / 0;
		%>
	</c:catch>
	<c:if test="${exceptionReference != null}">
		<p>
			The type of exception is : $ {exceptionReference} <br /> There is an
			exception: $ {exceptionReference.message}
		</p>
	</c:if>


	<br>
	<br>
	<a href="index.jsp">Index Page</a>
</body>
</html>
