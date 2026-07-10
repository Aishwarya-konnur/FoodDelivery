<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.container{
    margin-top:30px;
}

.card{
    border-radius:15px;
    overflow:hidden;
    transition:.3s;
    margin-bottom:25px;
}

.card:hover{
    transform:scale(1.03);
    box-shadow:0 8px 20px rgba(0,0,0,.2);
}

.card img{
    width:100%;
    height:220px;
    object-fit:cover;
}

.price{
    color:green;
    font-size:22px;
    font-weight:bold;
}

.available{
    color:green;
    font-weight:bold;
}

.notavailable{
    color:red;
    font-weight:bold;
}

.btn{
    width:100%;
}

</style>

</head>

<body>

<div class="container">

<h2 class="text-center mb-4">

🍴 Restaurant Menu

</h2>

<div class="row">

<%

List<Menu> menuList=(List<Menu>)request.getAttribute("menuList");

if(menuList!=null){

for(Menu menu:menuList){

%>

<div class="col-md-4">

<div class="card shadow">

<img src="<%=menu.getImage()%>" alt="Food Image">

<div class="card-body">

<h4>

<%=menu.getItemName()%>

</h4>

<p>

<%=menu.getDescription()%>

</p>

<p class="price">

₹ <%=menu.getPrice()%>

</p>

<p>

⭐ 4.5

</p>

<p class="<%=menu.isAvailable()?"available":"notavailable"%>">

<%=menu.isAvailable()?"✔ Available":"✖ Not Available"%>

</p>

<form action="CartServlet" method="post">

    <input type="hidden"
           name="menuId"
           value="<%=menu.getMenuId()%>">

    <input type="hidden"
           name="quantity"
           value="1">

    <p class="text-success fw-bold mb-2">
        🚚 Delivery in 25-30 mins
    </p>

    <p class="text-muted mb-3">
        💰 Delivery Charge: ₹30
    </p>

    <button class="btn btn-success">
        🛒 Add To Cart
    </button>

</form>

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