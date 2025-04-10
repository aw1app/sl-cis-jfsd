<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/header.jsp"%>

<!DOCTYPE html>
<html>

<h2>Enter the product your are searching for:</h2>

<form ACTION="find-by-name-using-custom-jpql" method="POST">

	<BR> ENTER NAME: <input name="name"> <BR>
	<BR> <input type="submit" value="SEARCH">

</form>