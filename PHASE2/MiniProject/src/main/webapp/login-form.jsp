<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />

<link rel="stylesheet" type="text/css" href="CSS/login.css">

<h2>LOGIN HERE</h2>

<form action="login.jsp" method="POST">
    <label for="username">User Name:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Submit">
</form>