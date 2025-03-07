<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<div>
	<a href="index.jsp"> HOME</a> | 	
</div>
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
		</tr>
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				<td>${row.id}
				<td>${row.name}
				<td>${row.category}
				<td>${row.price}
			</tr>
		</c:forEach>
	</table>
</center>
