<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"  %>

<html>


<h1> SEARCH PRODUCTS BY PRICE</h1>

<form ACTION="find-by-price-range" method="POST">

<BR> ENTER STARTING FROM : <input name="price1">
BR> ENTER UPTO: <input name="price2">

<BR><BR>  <input type="submit" value="SEARCH" >

</form>