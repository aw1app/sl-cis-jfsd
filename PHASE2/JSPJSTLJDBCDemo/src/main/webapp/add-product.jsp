<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:update dataSource="${myEstore}" var="count">
	INSERT INTO PRODUCTS(name,price,category) VALUES ('${param.name}',${param.price}, '${param.category}')
</sql:update>

<br>


<c:if test="${count > 0 }">
	<c:redirect url="products.jsp?message=${count} no of products inserted successfully!"></c:redirect>
</c:if>

