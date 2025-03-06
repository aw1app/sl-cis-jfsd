<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="product1" class="com.sl.Product">   
    
    </jsp:useBean>
    
   <jsp:setProperty property="name" param="name" name="product1" />
   <jsp:setProperty property="price" param="price" name="product1" />
   
   
   
   <br><br>
   Testing if we have captured the form submission:
   
   <br>  Name  <%=product1.getName() %>
   <br>  Price  <%=product1.getPrice() %>