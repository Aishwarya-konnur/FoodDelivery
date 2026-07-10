<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.Menu"%>
<%@ page import="com.tap.DAOImpl.MenuDAOImpl"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.container{
    margin-top:40px;
    margin-bottom:40px;
}

.card{
    border-radius:15px;
}

img{
    border-radius:10px;
}

</style>

</head>

<body>

<div class="container">

<div class="card shadow">

<div class="card-header bg-success text-white">

<h2 class="text-center">Checkout</h2>

</div>

<div class="card-body">

<table class="table table-hover align-middle">

<tr class="table-dark">

<th>Image</th>
<th>Food Item</th>
<th>Price</th>
<th>Qty</th>
<th>Subtotal</th>

</tr>

<%

List<Cart> cartList=(List<Cart>)request.getAttribute("cartList");

MenuDAOImpl menuDAO=new MenuDAOImpl();

double grandTotal=0;

if(cartList!=null){

for(Cart cart:cartList){

Menu menu=menuDAO.getMenu(cart.getMenuId());

if(menu!=null){

double subtotal=menu.getPrice()*cart.getQuantity();

grandTotal+=subtotal;

%>

<tr>

<td>

<img src="<%=menu.getImage()%>"
width="80"
height="70">

</td>

<td>

<b><%=menu.getItemName()%></b>

</td>

<td>

₹ <%=menu.getPrice()%>

</td>

<td>

<%=cart.getQuantity()%>

</td>

<td>

<b class="text-success">

₹ <%=subtotal%>

</b>

</td>

</tr>

<%

}

}

}

%>

</table>

<hr>

<div class="text-end">

<h3>

Grand Total :

<span class="text-danger">

₹ <%=grandTotal%>

</span>

</h3>

</div>

<hr>

<form action="PlaceOrderServlet" method="post">



<input type="hidden"
       name="amount"
       value="<%=grandTotal%>">

<div class="mb-3">

<label class="form-label">

<b>Delivery Address</b>

</label>

<textarea
class="form-control"
name="address"
rows="3"
placeholder="Enter your delivery address..."
required></textarea>

</div>

<div class="mb-4">

<label class="form-label">
<b>Select Payment Method</b>
</label>

<div class="form-check">

<input class="form-check-input"
type="radio"
name="payment"
value="Cash On Delivery"
checked
onclick="togglePayment()">

<label class="form-check-label">
💵 Cash On Delivery
</label>

</div>

<div class="form-check">

<input class="form-check-input"
type="radio"
name="payment"
value="Online Payment"
onclick="togglePayment()">

<label class="form-check-label">
💳 Online Payment
</label>

</div>

</div>
<div id="onlinePayment" style="display:none;">

<div class="card p-3 bg-light">

<h5 class="text-primary">

💳 Online Payment Details

</h5>

<div class="mb-3">

<label>Card Holder Name</label>

<input
type="text"
class="form-control"
name="cardHolder">

</div>

<div class="mb-3">

<label>Card Number</label>

<input
type="text"
class="form-control"
maxlength="16"
placeholder="1234 5678 9012 3456"
name="cardNumber">

</div>

<div class="row">

<div class="col">

<label>Expiry</label>

<input
type="text"
class="form-control"
placeholder="MM/YY"
name="expiry">

</div>

<div class="col">

<label>CVV</label>

<input
type="password"
class="form-control"
maxlength="3"
name="cvv">

</div>

</div>

<br>

<label>OR UPI ID</label>

<input
type="text"
class="form-control"
placeholder="example@upi"
name="upiId">

</div>

</div>
<div class="d-flex justify-content-between">

<a href="ViewCartServlet"
class="btn btn-secondary">

⬅ Back to Cart

</a>

<button
type="submit"
class="btn btn-success">

Place Order

</button>

</div>

</form>

</div>

</div>

</div>
<script>

function togglePayment(){

let payment =
document.querySelector("input[name='payment']:checked").value;

let box =
document.getElementById("onlinePayment");

if(payment=="Online Payment"){

box.style.display="block";

}
else{

box.style.display="none";

}

}

window.onload=togglePayment;

</script>
</body>
</html>