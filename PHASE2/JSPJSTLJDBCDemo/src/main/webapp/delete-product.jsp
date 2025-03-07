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
	DELETE FROM PRODUCTS WHERE id=${param.id}
</sql:update>

<br>
<c:if test="${count > 0 }">
	<c:redirect url="products.jsp?message=${count} no of product(s) deleted successfully!"></c:redirect>
</c:if>
