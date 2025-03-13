<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<%	if (session!=null && session.getAttribute("loggedin")!= null && session.getAttribute("loggedin").equals("true")) {	%>
	


<center>
	<c:if test="${not empty param.message}">
	${param.message}
	</c:if>
</center>

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products
</sql:query>

<br>
<h2 style="text-align: center">LIST OF PRODUCTS</h2>
<center>
	<table border=1 style="text-align: center">
		<tr style="background-color: lightgrey">
			<th>ID
			<th>NAME
			<th>PRICE
			<th>CATEGORY
			<th>EDIT
			<th>DELETE
		</tr>
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				<td>${row.id}
				<td>${row.name}
				<td>${row.category}
				<td>${row.price}
				<td><a href="edit-product.jsp?id=${row.id}" > EDIT </a>
				<td><a href="delete-product.jsp?id=${row.id}" > DELETE </a>
			</tr>
		</c:forEach>
	</table>
</center>


<%	} else {  %>
<h3 style="color:red"> You need to be logged in to see the list of products! </h3>
<%	}   %>

<!-- 
CHALLENGE: 
1. Always display product list page irrespective of the user logged in or not
2. Display the Edit and Delete action links only if the user is logged in
 -->
