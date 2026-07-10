<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Order"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Orders</title>

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

<h2 class="text-center mb-4">Manage Orders</h2>

<table class="table table-bordered table-hover">

<tr class="table-dark">

<th>Order ID</th>
<th>User ID</th>
<th>Total Amount</th>
<th>Status</th>
<th>Order Date</th>

</tr>

<%

List<Order> orderList =
(List<Order>)request.getAttribute("orderList");

if(orderList != null){

for(Order order : orderList){

%>

<tr>

<td><%=order.getOrderId()%></td>

<td><%=order.getUserId()%></td>

<td>₹ <%=order.getTotalAmount()%></td>

<td>

<form action="UpdateOrderStatusServlet" method="post">

<input type="hidden"
       name="orderId"
       value="<%=order.getOrderId()%>">

<select
class="form-select"
name="status">

<option <%=order.getStatus().equals("PLACED")?"selected":""%>>
PLACED
</option>

<option <%=order.getStatus().equals("PREPARING")?"selected":""%>>
PREPARING
</option>

<option <%=order.getStatus().equals("OUT FOR DELIVERY")?"selected":""%>>
OUT FOR DELIVERY
</option>

<option <%=order.getStatus().equals("DELIVERED")?"selected":""%>>
DELIVERED
</option>

</select>

<br>

<button
class="btn btn-success btn-sm">

Update

</button>

</form>

</td>

<td><%=order.getOrderDate()%></td>

</tr>

<%

}

}

%>

</table>

<div class="text-center">

<a href="admin.jsp"
class="btn btn-primary">

⬅ Back to Dashboard

</a>

</div>

</div>

</body>
</html>