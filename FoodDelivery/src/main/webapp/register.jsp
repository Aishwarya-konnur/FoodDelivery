<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.register-container{
    width:450px;
    margin:50px auto;
}

.card{
    border-radius:15px;
}

.btn-register{
    width:100%;
}

</style>

</head>
<body>

<div class="container">

    <div class="register-container">

        <div class="card shadow">

            <div class="card-header bg-success text-white text-center">
                <h3>Create Account</h3>
            </div>

            <div class="card-body">

                <form action="RegisterServlet" method="post">

                    <div class="mb-3">
                        <label>User Name</label>
                        <input type="text"
                               name="userName"
                               class="form-control"
                               required>
                    </div>

                    <div class="mb-3">
                        <label>Email</label>
                        <input type="email"
                               name="email"
                               class="form-control"
                               required>
                    </div>

                    <div class="mb-3">
                        <label>Password</label>
                        <input type="password"
                               name="password"
                               class="form-control"
                               required>
                    </div>

                    <div class="mb-3">
                        <label>Address</label>
                        <textarea
                            name="address"
                            class="form-control"
                            rows="3"
                            required></textarea>
                    </div>

                    <input type="hidden"
                           name="role"
                           value="customer">

                    <button type="submit"
                            class="btn btn-success btn-register">

                        Register

                    </button>

                </form>

            </div>

            <div class="card-footer text-center">

                Already have an account?

                <a href="login.jsp">
                    Login Here
                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>