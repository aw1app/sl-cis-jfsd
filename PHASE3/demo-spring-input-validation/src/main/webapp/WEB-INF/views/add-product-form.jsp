<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"%>


<h2>ADD PRODUCT</h2>

<form ACTION="add-product" method="POST">

	<BR> NAME: <input name="name" id="name" value="${product.name}">
	<div style="color: red">
		<c:if
			test="${not empty errors.hasFieldErrors('name')}">
			<c:forEach var="error"
				items="${errors.getFieldErrors('name')}">
				<p>${error.defaultMessage}</p>
			</c:forEach>
		</c:if>
	</div>


	<BR> PRICE: <input name="price" value="${product.price}"> 
	
	<div style="color: red">
		<c:if
			test="${not empty errors.hasFieldErrors('price')}">
			<c:forEach var="error"
				items="${errors.getFieldErrors('price')}">
				<p>${error.defaultMessage}</p>
			</c:forEach>
		</c:if>
	</div>
	
	
	
	<BR> <BR> <input
		type="submit" value="ADD PRODUCT">
		
		

</form>