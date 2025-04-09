<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"  %>


<h2>EDIT PRODUCT</h2>

<form ACTION="edit-product" method="POST">
<BR> NAME: <input name="id" value="${product.id}" read-only>
<BR> NAME: <input name="name" value="${product.name}">
<BR> PRICE: <input name="price" value="${product.price}">

<BR><BR>  <input type="submit" value="SAVE PRODUCT" >

</form>