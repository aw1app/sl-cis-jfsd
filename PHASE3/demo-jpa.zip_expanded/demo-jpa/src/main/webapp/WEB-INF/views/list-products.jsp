<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"  %>


<h2>PRODUCTS LIST</h2>

<table border="1">
<thead>
			<th>ID
			<th>NAME
			<th>PRICE
			<th> EDIT
			<th> DELETE
		</thead>
	
	<c:forEach var="product" items="${listOfProducts}">
		<tr>
			<td>${product.id}
			<td>${product.name}
			<td>${product.price}
			<td><a href="edit-product?id=${product.id}"> EDIT </a>
			<td><a href="delete-product?id=${product.id}"> DELETE </a>
		</tr>
	</c:forEach>

</table>

