<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />


<%
	session.invalidate();

	out.println("<br><br><b>LOGOUT Successfull.</b>");
%>