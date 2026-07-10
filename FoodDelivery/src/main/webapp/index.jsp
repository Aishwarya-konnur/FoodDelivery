<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instant Food Delivery</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
}

.hero{
    height:90vh;
    background: linear-gradient(rgba(0,0,0,0.5),
    rgba(0,0,0,0.5)),
    url("https://images.unsplash.com/photo-1504674900247-0877df9cc836");
    background-size:cover;
    background-position:center;
    color:white;
    display:flex;
    justify-content:center;
    align-items:center;
    text-align:center;
}

.hero h1{
    font-size:60px;
    font-weight:bold;
}

.hero p{
    font-size:20px;
}

.feature-card{
    transition:0.3s;
}

.feature-card:hover{
    transform:translateY(-5px);
}

.footer{
    background:#212529;
    color:white;
    padding:20px;
    text-align:center;
}
</style>

</head>
<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
    
        <a class="navbar-brand" href="#">
            🍔 Instant Food
        </a>

        <button class="navbar-toggler"
        data-bs-toggle="collapse"
        data-bs-target="#menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menu">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="restaurants.jsp">Restaurants</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>

            </ul>

        </div>
    </div>
</nav>

<!-- Hero Section -->

<section class="hero">

    <div>

        <h1>Instant Food Delivery</h1>

        <p>
            Order food from your favorite restaurants
            and get it delivered fast.
        </p>

        <a href="RestaurantServlet" class="btn btn-warning btn-lg">
          Order Now
        </a>

    </div>

</section>

<!-- Features -->

<div class="container mt-5 mb-5">

    <div class="row text-center">

        <div class="col-md-4">

            <div class="card feature-card p-4">

                <h3>🍕 Best Restaurants</h3>

                <p>
                    Explore top-rated restaurants
                    near you.
                </p>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card feature-card p-4">

                <h3>⚡ Fast Delivery</h3>

                <p>
                    Get your food delivered
                    within minutes.
                </p>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card feature-card p-4">

                <h3>💳 Easy Payments</h3>

                <p>
                    Secure and hassle-free
                    payment options.
                </p>

            </div>

        </div>

    </div>

</div>

<!-- Footer -->

<div class="footer">

    <h5>Instant Food Delivery</h5>

    <p>
        © 2026 All Rights Reserved
    </p>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>