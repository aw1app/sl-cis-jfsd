<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<a href="index.jsp"> HOME </a> |
	<a href="list-products"> PRODUCTS LIST </a> |
	<a href="add-product"> ADD PRODUCT</a> |

	<BR>
	<a href="/products-by-name.jsp"> FIND PRODUCT BY NAME </a> |
	<a href="/products-by-price-range.jsp"> FIND PRODUCT BY PRICE RANGE
	</a> |
	<a href="/products-by-name-using-JPQL.jsp"> FIND PRODUCT BY NAME
		(using custom JPQL) </a> |
	<a href="/products-by-name-using-JPQL.jsp"> FIND PRODUCT BY NAME
		(using native SQL) </a> |

</body>
</html>