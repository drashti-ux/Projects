<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="Validations.js"></script>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="header.jsp" %>

<div class="d-flex align-items-center justify-content-center mt-5">
    <div class="container col-md-4 mx-auto" style="margin-top: 100px;">
        <div class="p-4 rounded shadow-lg" style="background-color: rgba(240, 240, 240, 0.95);">

            <form action="loginUser" id="logForm" method="post">
                <h1 class="text-center mb-3 text-dark">Login</h1>
                <hr>
				<span class="text-danger text-center"><h4>${msg}</h4></span>
                <div class="form-group mt-2">
                    <label for="email" class="text-dark">Email:</label>
                    <input type="email" name="email" id="email" placeholder="Enter Email" class="form-control mt-1">
                    <span id="emailEr" class="text-danger"></span>
                </div>

                <div class="form-group mt-2">
                    <label for="pass" class="text-dark">Password:</label>
                    <input type="password" name="pass" id="pass" placeholder="Enter Password" class="form-control mt-1">
                    <span id="passEr" class="text-danger"></span>
                </div>

                <div class="form-group mt-4 d-flex ">
                    <input type="submit" name="subtn" value="Login" class="btn btn-success">
                    <a href="/Expense_Tracker/view/forgotPass.jsp" class="btn btn-outline-dark ms-2">Forgot Password</a>
                </div>
                
                <div class="form-group mt-4 d-flex ">
                 <span class="text-dark">Not Registered Yet ?&nbsp</span><a href="registerUser.jsp"> Register Here..</a>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
