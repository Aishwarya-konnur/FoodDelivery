<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Users</title>

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

<h2 class="text-center mb-4">Manage Users</h2>

<table class="table table-bordered table-hover">

<tr class="table-dark">

<th>User ID</th>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Role</th>

</tr>

<%

List<User> userList =
(List<User>)request.getAttribute("userList");

if(userList != null){

for(User user : userList){

%>

<tr>

<td><%=user.getUserId()%></td>
<td><%=user.getUserName()%></td>
<td><%=user.getEmail()%></td>
<td><%=user.getAddress()%></td>
<td><%=user.getRole()%></td>

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