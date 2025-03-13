<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/products.css">
</head>
<body>

<jsp:include page="header.jsp" />

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estore" user="root"
	password="rootroot" />

<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products
</sql:query>

<div class="container">
    <c:if test="${not empty param.message}">
        <div class="message">${param.message}</div>
    </c:if>

    <h2>LIST OF PRODUCTS</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>CATEGORY</th>
                <c:if test="${sessionScope.loggedin eq 'true'}">
                    <th>EDIT</th>
                    <th>DELETE</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${resultSet.rows}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                    <td>${row.price}</td>
                    <td>${row.category}</td>
                    <c:if test="${sessionScope.loggedin eq 'true'}">
                        <td><a href="edit-product.jsp?id=${row.id}" class="btn edit">EDIT</a></td>
                        <td><a href="delete-product.jsp?id=${row.id}" class="btn delete">DELETE</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${sessionScope.loggedin ne 'true'}">
        <p class="alert">You need to be logged in to edit or delete products.</p>
    </c:if>
</div>

</body>
</html>

<!-- 
CHALLENGE: 
1. Always display product list page irrespective of the user logged in or not
2. Display the Edit and Delete action links only if the user is logged in
 -->
