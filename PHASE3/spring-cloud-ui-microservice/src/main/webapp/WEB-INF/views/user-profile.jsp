<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@include file="/header.jsp"  %>


<h2>PROFILE DETAILS</h2>

<table border="1">
<thead>
			<th>ID
			<th>NAME
			<th>MEMBERSHIP
		</thead>
	
		<tr>
			<td>${userProfile.id}
			<td>${userProfile.name}
			<td>${userProfile.subscriberType}
			
		</tr>

</table>
