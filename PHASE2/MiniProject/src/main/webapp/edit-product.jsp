<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="add-edit-product.css">
</head>
<body>

<jsp:include page="header.jsp" />

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products WHERE id='${param.id}'
</sql:query>

<div class="container">
    <h2>Edit Product</h2>

    <c:forEach var="row" items="${resultSet.rows}">
        <form action="save-edited-product.jsp" method="post" class="edit-form">
            <input name="id" value="${row.id}" type="hidden">
            
            <br>

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" value="${row.name}" disabled>
            </div>
            
          

            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="${row.price}" required>
            </div>
            
            

            <div class="form-group">
                <label for="category">Category:</label>
                <input type="text" id="category" name="category" value="${row.category}" required>
            </div>
            
            <br>

            <button type="submit" class="btn save">Save Changes</button>
        </form>
    </c:forEach>
</div>

</body>
</html>
