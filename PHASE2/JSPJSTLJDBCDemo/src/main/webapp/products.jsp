<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products
</sql:query>

<br>
<h2 style="text-align:center">LIST OF PRODUCTS</h2>
<center>
<table border=1 style="text-align:center">
	<c:forEach var="row" items="${resultSet.rows}">
		<tr style="background-color:lightgrey">
			<td>${row.id}
			<td>${row.name}
			<td>${row.category}
			<td>${row.price}
		</tr>
	</c:forEach>
</table>
</center>
