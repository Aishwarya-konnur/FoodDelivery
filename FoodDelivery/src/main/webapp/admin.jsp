<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.User" %>

<%
User user = (User) session.getAttribute("loggedUser");

if (user == null || !"Admin".equalsIgnoreCase(user.getRole())) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.card{
    margin-top:30px;
    border-radius:15px;
}

.btn{
    margin:10px;
    width:250px;
}

</style>

</head>
<body>

<div class="container">

<div class="card shadow">

<div class="card-header bg-dark text-white text-center">

<h2>Admin Dashboard</h2>

</div>

<div class="card-body text-center">
<div class="row mb-4">

    <div class="col-md-3">
        <div class="card bg-primary text-white">
            <div class="card-body">
                <h5>Total Users</h5>
                <h2><%=request.getAttribute("totalUsers")%></h2>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="card bg-success text-white">
            <div class="card-body">
                <h5>Restaurants</h5>
                <h2><%=request.getAttribute("totalRestaurants")%></h2>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="card bg-warning text-dark">
            <div class="card-body">
                <h5>Orders</h5>
                <h2><%=request.getAttribute("totalOrders")%></h2>
            </div>
        </div>
    </div>

    <div class="col-md-3">
        <div class="card bg-danger text-white">
            <div class="card-body">
                <h5>Revenue</h5>
                <h2>₹ <%=request.getAttribute("totalRevenue")%></h2>
            </div>
        </div>
    </div>

</div>

<a href="RestaurantServlet" class="btn btn-primary">
🏪 Manage Restaurants
</a>

<br>

<a href="ManageMenuServlet" class="btn btn-success">
🍕 Manage Menu
</a>

<br>

<a href="AllOrdersServlet" class="btn btn-warning">
📦 Manage Orders
</a>

<br>

<a href="ManageUsersServlet" class="btn btn-info">
👥 Manage Users
</a>

<br>

<a href="LogoutServlet" class="btn btn-danger">
🚪 Logout
</a>

</div>

</div>

</div>

</body>
</html>