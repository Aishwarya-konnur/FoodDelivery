<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.DAOImpl.MenuDAOImpl"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.container{
    margin-top:40px;
}

table{
    background:white;
}

</style>

</head>

<body>

<div class="container">

<h2 class="text-center mb-4">🛒 My Cart</h2>

<table class="table table-bordered table-hover">

<tr class="table-dark">

<th>Image</th>

<th>Food Name</th>

<th>Price</th>

<th>Quantity</th>

<th>Subtotal</th>

<th>Action</th>

</tr>


<%

double grandTotal = 0;

List<Cart> cartList = (List<Cart>)request.getAttribute("cartList");

if(cartList != null && !cartList.isEmpty()){
	
    for(Cart cart : cartList){
    	MenuDAOImpl menuDAO = new MenuDAOImpl();

    	Menu menu = menuDAO.getMenu(cart.getMenuId());

    	double subtotal = menu.getPrice() * cart.getQuantity();
    	grandTotal += subtotal;
%>

<tr>

<td><%=cart.getCartId()%></td>

<tr>

<td>
<img src="<%=menu.getImage()%>"
width="100"
height="80"
style="border-radius:10px;">
</td>

<td>
<%=menu.getItemName()%>
</td>

<td>
₹ <%=menu.getPrice()%>
</td>

<td>

<a href="UpdateCartServlet?cartId=<%=cart.getCartId()%>&action=decrease"
class="btn btn-warning btn-sm">

-

</a>

&nbsp;

<b><%=cart.getQuantity()%></b>

&nbsp;

<a href="UpdateCartServlet?cartId=<%=cart.getCartId()%>&action=increase"
class="btn btn-success btn-sm">

+

</a>

</td>

<td>
₹ <%=subtotal%>
</td>

<td>

<a href="DeleteCartServlet?cartId=<%=cart.getCartId()%>"
class="btn btn-danger btn-sm">

Remove

</a>

</td>

</tr>


<%
    }
}
else{
%>

<tr>
<td colspan="4" class="text-center">
Your Cart is Empty
</td>
</tr>

<%
}
%>

</table>
<div class="text-end mt-3">

<h3>

Grand Total :
<span class="text-success">

₹ <%=grandTotal%>

</span>

</h3>

</div>

<%
Integer restaurantId = (Integer)session.getAttribute("restaurantId");
%>

<div class="text-center mt-4">

<% if(restaurantId != null){ %>

<a href="MenuServlet?restaurantId=<%=restaurantId%>"
class="btn btn-primary">

⬅ Continue Shopping

</a>

<% } %>

<a href="CheckoutServlet"
class="btn btn-success">

Proceed To Checkout

</a>

</div>

</div>

</body>
</html>