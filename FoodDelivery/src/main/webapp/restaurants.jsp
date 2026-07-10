<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurants</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
   background:#eef2f7;
}

h2{
    font-weight:bold;
    margin-bottom:30px;
}

.card{
     border:none;
    border-radius:20px;
    overflow:hidden;
    transition:0.3s;
    background:white;
}

.card:hover{
transform:translateY(-8px);
    box-shadow:0px 15px 35px rgba(0,0,0,.2);
}

.card img{
    height:230px;
    object-fit:cover;
}

.rating{
    color:#ff9800;
    font-weight:bold;
}

.delivery{
    color:#28a745;
    font-weight:bold;
}

.btn{
    width:100%;
}

</style>

</head>

<body>
<%@ page import="com.tap.model.User"%>

<%
User user=(User)session.getAttribute("loggedUser");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow">

<div class="container-fluid">

<a class="navbar-brand fw-bold" href="#">
🍔 Instant Food
</a>

<div class="d-flex align-items-center">

<span class="text-white me-4">

Welcome,
<b><%=user!=null?user.getUserName():"Guest"%></b>

</span>

<a href="ViewCartServlet" class="btn btn-warning me-2">
🛒 Cart
</a>

<a href="MyOrdersServlet" class="btn btn-info me-2">
📦 My Orders
</a>

<a href="LogoutServlet" class="btn btn-danger">
Logout
</a>

</div>

</div>

</nav>

<div class="container">

<h2 class="text-center mt-4">

🍽 Available Restaurants

</h2>
<div class="row mt-4 mb-4">

<div class="col-md-6 mx-auto">

<input
type="text"
class="form-control form-control-lg"
placeholder="🔍 Search Restaurants...">

</div>

</div>
<div class="row">

<%

List<Restaurant> restaurants =
(List<Restaurant>)request.getAttribute("restaurantList");

if(restaurants!=null){

for(Restaurant r : restaurants){

%>

<div class="col-md-4">

<div class="card shadow">

<img src="<%=r.getImage()%>" alt="Restaurant">

<div class="card-body">

<h4 class="fw-bold">
<%=r.getRestaurantName()%>
</h4>

<span class="badge bg-success">
⭐ <%=r.getRating()%>
</span>

<hr>

<p>

<p>

🍴 <b>Cuisine:</b><br>

<%=r.getCuisineType()%>

</p>

<p>
📍 <b>Location</b><br>
<%=r.getAddress()%>
</p>

<p class="text-success">
🚚 Delivery in <%=r.getDeliveryTime()%> mins
</p>

<a href="MenuServlet?restaurantId=<%=r.getRestaurantId()%>"
class="btn btn-success">

View Menu →

</a>

</div>

</div>

</div>

<%

}

}

%>

</div>

</div>

</body>

</html>