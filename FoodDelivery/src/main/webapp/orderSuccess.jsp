<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Successful</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.success{
    margin-top:70px;
}

.card{
    border-radius:15px;
}

.tick{
    font-size:70px;
}

</style>

</head>

<body>

<div class="container">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow">

<div class="card-body text-center">

<div class="tick">✅</div>

<h2 class="text-success">

Order Placed Successfully

</h2>

<p>

Thank You for Ordering with <b>Instant Food</b>

</p>

<hr>

<p>

<b>Delivery Address :</b><br>

<%=request.getAttribute("address")%>

</p>

<p>

<b>Payment Method :</b><br>

<%=request.getAttribute("payment")%>

</p>

<p>

<b>Total Amount :</b><br>

₹ <%=request.getAttribute("amount")%>

</p>

<hr>

<a href="RestaurantServlet"
class="btn btn-primary">

🍴 Order Again

</a>

<a href="MyOrdersServlet"
class="btn btn-success">

📦 My Orders

</a>

</div>

</div>

</div>

</div>

</div>

</body>

</html>