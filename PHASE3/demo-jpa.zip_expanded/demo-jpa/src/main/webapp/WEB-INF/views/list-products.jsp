<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<h2>PRODUCTS LIST</h2>

<table border="1">
<thead>
			<th>ID
			<th>NAME
			<th>PRICE
		</thead>
	
	<c:forEach var="product" items="${listOfProducts}">
		<tr>
			<td>${product.id}
			<td>${product.name}
			<td>${product.price}
		</tr>
	</c:forEach>

</table>

