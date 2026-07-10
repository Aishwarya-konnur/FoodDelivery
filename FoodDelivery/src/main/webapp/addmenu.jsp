<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Menu Item</title>

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

<div class="card-header bg-success text-white">

<h3>Add Menu Item</h3>

</div>

<div class="card-body">

<form action="AddMenuServlet" method="post">

<div class="mb-3">
<label>Restaurant ID</label>
<input type="number"
name="restaurantId"
class="form-control"
required>
</div>

<div class="mb-3">
<label>Item Name</label>
<input type="text"
name="itemName"
class="form-control"
required>
</div>

<div class="mb-3">
<label>Description</label>
<textarea
name="description"
class="form-control"
required></textarea>
</div>

<div class="mb-3">
<label>Price</label>
<input type="number"
step="0.01"
name="price"
class="form-control"
required>
</div>

<div class="mb-3">
<label>Image URL</label>
<input type="text"
name="image"
class="form-control">
</div>

<div class="mb-3">

<label>Available</label>

<select
name="available"
class="form-select">

<option value="true">Yes</option>
<option value="false">No</option>

</select>

</div>

<button
class="btn btn-success">

Add Menu

</button>

<a href="ManageMenuServlet"
class="btn btn-secondary">

Cancel

</a>

</form>

</div>

</div>

</div>

</body>
</html>