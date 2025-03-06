<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="product1" class="com.sl.Product"  scope="session">   
    
    </jsp:useBean>
    
  
   
   <br><br>
   Testing if we have product1 bean object in the session:
   
   <br>  Name  <%=product1.getName() %>
   <br>  Price  <%=product1.getPrice() %>