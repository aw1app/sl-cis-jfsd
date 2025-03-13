<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products WHERE id='${param.id}'
</sql:query>

<br>

<c:forEach var="row" items="${resultSet.rows}">

	<form action="save-edited-product.jsp" method="post">

		<br><input name="id" value="${row.id}" type="hidden"> <br>
		<br>Name: ${row.name } <br>
		<br>Price: <input name="price" value="${row.price}"> <br>
		<br>Category: <input name="category" value="${row.category}">

		<br>
		<br>
		<input type="submit" value="Submit">

	</form>

</c:forEach>

