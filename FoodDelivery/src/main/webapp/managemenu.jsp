<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Menu</title>

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

<h2 class="text-center mb-4">Manage Menu</h2>

<div class="mb-3 text-end">

<a href="addmenu.jsp" class="btn btn-success">
➕ Add Menu Item
</a>

</div>

<table class="table table-bordered table-hover">

<tr class="table-dark">
    <th>Menu ID</th>
    <th>Restaurant ID</th>
    <th>Item Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Available</th>
    <th>Action</th>
</tr>

<%
List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");

if(menuList != null){

for(Menu menu : menuList){
%>

<tr>

<td><%=menu.getMenuId()%></td>
<td><%=menu.getRestaurantId()%></td>
<td><%=menu.getItemName()%></td>
<td><%=menu.getDescription()%></td>
<td>₹ <%=menu.getPrice()%></td>
<td><%=menu.isAvailable() ? "Yes" : "No"%></td>

<td>

<a href="EditMenuServlet?menuId=<%=menu.getMenuId()%>"
class="btn btn-warning btn-sm">

Edit

</a>

<a href="DeleteMenuServlet?menuId=<%=menu.getMenuId()%>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this menu item?')">

Delete

</a>

</td>

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