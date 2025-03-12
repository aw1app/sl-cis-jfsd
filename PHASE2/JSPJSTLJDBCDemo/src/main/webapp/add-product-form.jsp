<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
	
	
<!DOCTYPE html>
<jsp:include page="header.jsp" />

<h2>ADD A NEW PRODUCT</h2>
<form action="add-product.jsp" method="POST">

	<br>Name: <input name="name"> <br>
	<br>Price: <input name="price"> <br>
	<br>Category: <input name="category"> <br>
	<br>
	<input type="submit" value="Submit">

</form>


