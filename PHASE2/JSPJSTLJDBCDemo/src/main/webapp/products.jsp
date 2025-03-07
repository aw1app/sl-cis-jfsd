<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>  
<%@ taglib prefix="sql" uri="jakarta.tags.sql"%>  

<!DOCTYPE html>

<sql:setDataSource var="myEstore" driver="com.mysql.cj.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/estore" user="root"	password="rootroot" />
	
<sql:query dataSource="${myEstore}" var="resultSet">
	SELECT * FROM products
</sql:query>	


<c:forEach var="row" items="${resultSet.rows}">

${row.id} 
${row.name} 
${row.category} 
${row.price} 
<br>
</c:forEach>
