<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>

<!--  ToolBar links in the header  -->
<div>
	<a href="index.jsp"> HOME</a> | 
	<a href="products.jsp">PRODUCTS LIST</a>	 |    
	<a href="add-product-form.jsp"> ADD NEW PRODUCT</a>	 |             
	
	<%	if (session!=null && session.getAttribute("loggedin")!= null && session.getAttribute("loggedin").equals("true")) {	%>
	<a href="logout.jsp"> LOGOUT </a>
	<%	} else {  %>
	<a href="login-form.jsp"> LOGIN </a>	
	<%	} %>
</div>

