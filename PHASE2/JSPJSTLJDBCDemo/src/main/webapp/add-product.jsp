<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<div>
	<a href="index.jsp"> HOME</a> | 	
</div>

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:update dataSource="${myEstore}" var="count">
	INSERT INTO PRODUCTS(name,price,category) VALUES ('${param.name}',${param.price}, '${param.category}')
</sql:update>

<br> <c:out value="${count}" /> no of rows inserted successfully!

