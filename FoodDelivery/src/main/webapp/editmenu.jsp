<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Menu"%>

<%
Menu menu = (Menu)request.getAttribute("menu");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Menu</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f5f5f5;
}

.container{
    width:600px;
    margin-top:40px;
}
</style>

</head>
<body>

<div class="container">

<div class="card shadow">

<div class="card-header bg-warning">

<h3>Edit Menu Item</h3>

</div>

<div class="card-body">

<form action="UpdateMenuServlet" method="post">

<input type="hidden"
       name="menuId"
       value="<%=menu.getMenuId()%>">

<div class="mb-3">

<label>Restaurant ID</label>

<input type="number"
name="restaurantId"
class="form-control"
value="<%=menu.getRestaurantId()%>"
required>

</div>

<div class="mb-3">

<label>Item Name</label>

<input type="text"
name="itemName"
class="form-control"
value="<%=menu.getItemName()%>"
required>

</div>

<div class="mb-3">

<label>Description</label>

<textarea
name="description"
class="form-control"
required><%=menu.getDescription()%></textarea>

</div>

<div class="mb-3">

<label>Price</label>

<input type="number"
step="0.01"
name="price"
class="form-control"
value="<%=menu.getPrice()%>"
required>

</div>

<div class="mb-3">

<label>Image URL</label>

<input type="text"
name="image"
class="form-control"
value="<%=menu.getImage()%>">

</div>

<div class="mb-3">

<label>Available</label>

<select
name="available"
class="form-select">

<option value="true" <%=menu.isAvailable() ? "selected" : ""%>>
Yes
</option>

<option value="false" <%=!menu.isAvailable() ? "selected" : ""%>>
No
</option>

</select>

</div>

<button class="btn btn-warning">
Update Menu
</button>

<a href="ManageMenuServlet" class="btn btn-secondary">
Cancel
</a>

</form>

</div>

</div>

</div>

</body>
</html>