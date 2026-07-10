<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.container{
    margin-top:40px;
}

</style>

</head>
<body>

<div class="container">

<h2 class="text-center mb-4">My Orders</h2>

<table class="table table-bordered table-hover">

<tr class="table-dark">

<th>Order ID</th>
<th>Order Date</th>
<th>Total Amount</th>
<th>Status</th>

</tr>

<%

List<Order> orderList = (List<Order>)request.getAttribute("orderList");

if(orderList != null && !orderList.isEmpty()){

for(Order order : orderList){

%>

<tr>

<td><%=order.getOrderId()%></td>

<td><%=order.getOrderDate()%></td>

<td>₹ <%=order.getTotalAmount()%></td>

<td>
<span class="badge bg-success">
<%=order.getStatus()%>
</span>
</td>

</tr>

<%
}

}else{
%>

<tr>

<td colspan="4" class="text-center">

No Orders Found

</td>

</tr>

<%
}
%>

</table>

<div class="text-center">

<a href="RestaurantServlet"
class="btn btn-primary">

Continue Shopping

</a>

</div>

</div>

</body>
</html>