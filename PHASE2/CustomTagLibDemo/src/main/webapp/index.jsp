<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%@ taglib prefix="cisco" uri="http://example.com/customtags"%>

<!DOCTYPE html>


<c:set var="x" value="100" />
<c:out value="${x}" />

<!--  Testing our custom Tag library -->
<cisco:greeting name="Sudhir" />
<cisco:greeting name="Mohan" />
<cisco:greeting name="Pavitra" />
<cisco:greeting name="Sibi" />