<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.container{
    margin-top:60px;
}

.card{
    border-radius:15px;
}

</style>

</head>

<body>

<div class="container">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow">

<div class="card-header bg-success text-white">

<h3>Payment</h3>

</div>

<div class="card-body">

<form action="PlaceOrderServlet" method="post">

<input type="hidden"
       name="payment"
       value="Online Payment">

<div class="mb-3">

<label>Total Amount</label>

<input
type="text"
class="form-control"
value="₹ <%=request.getAttribute("amount")%>"
readonly>

</div>

<div class="mb-3">

<label>Delivery Address</label>

<textarea
class="form-control"
name="address"
required><%=request.getParameter("address")%></textarea>

</div>

<div class="mb-3">

<label>Select Payment Method</label>

<select
class="form-select"
name="payment"
id="payment"
onchange="showFields()">

<option value="COD">Cash On Delivery</option>
<option value="UPI">UPI</option>
<option value="CARD">Credit / Debit Card</option>

</select>

</div>

<div id="upiBox" style="display:none;">

<label>UPI ID</label>

<input
type="text"
class="form-control"
placeholder="example@upi">

</div>

<div id="cardBox" style="display:none;">

<label>Card Number</label>

<input
type="text"
class="form-control"
placeholder="1234 5678 9012 3456">

<br>

<label>Expiry</label>

<input
type="text"
class="form-control"
placeholder="MM/YY">

<br>

<label>CVV</label>

<input
type="password"
class="form-control"
placeholder="123">

</div>

<br>

<button
class="btn btn-success w-100">

Pay Now

</button>

</form>

</div>

</div>

</div>

</div>

</div>

<script>

function showFields(){

var payment=document.getElementById("payment").value;

document.getElementById("upiBox").style.display="none";

document.getElementById("cardBox").style.display="none";

if(payment=="UPI"){

document.getElementById("upiBox").style.display="block";

}

if(payment=="CARD"){

document.getElementById("cardBox").style.display="block";

}

}

</script>

</body>

</html>