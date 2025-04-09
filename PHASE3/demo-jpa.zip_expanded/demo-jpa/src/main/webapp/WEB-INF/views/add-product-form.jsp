<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"  %>


<h2>ADD PRODUCT</h2>

<form ACTION="add-product" method="POST">

<BR> NAME: <input name="name">
<BR> PRICE: <input name="price">

<BR><BR>  <input type="submit">

</form>