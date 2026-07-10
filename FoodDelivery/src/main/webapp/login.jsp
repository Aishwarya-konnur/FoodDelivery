<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f5f5f5;
}

.login-container{
    width:400px;
    margin:100px auto;
}

</style>

</head>
<body>

<div class="container">

    <div class="login-container">

        <div class="card shadow">

            <div class="card-header bg-primary text-white text-center">
                <h3>User Login</h3>
            </div>

            <div class="card-body">
            <%
String error = (String) request.getAttribute("error");

if(error != null){
%>

<div class="alert alert-danger">

<%=error%>

</div>

<%
}
%>

                <form action="LoginServlet" method="post">

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

                    <button type="submit"
                            class="btn btn-primary w-100">

                        Login

                    </button>

                </form>

            </div>

            <div class="card-footer text-center">

                New User?

                <a href="register.jsp">
                    Register Here
                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>