<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" %>
	
	
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/add-edit-product.css">
</head>
<body>

<jsp:include page="header.jsp" />

<div class="container">
    <h2>Add a New Product</h2>

    <form action="add-product.jsp" method="POST" class="add-form">
        <div class="form-group">
            <label for="name">Product Name:</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" required>
        </div>

        <div class="form-group">
            <label for="category">Category:</label>
            <input type="text" id="category" name="category" required>
        </div>

<br><br>
        <button type="submit" class="btn add">Add Product</button>
    </form>
</div>

</body>
</html>



