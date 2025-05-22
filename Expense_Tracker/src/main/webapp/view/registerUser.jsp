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

<%@include file="header.jsp" %>

<div class="d-flex align-items-center" style="height: 100vh;">
  <div class="container p-5 card col-4 mx-auto bg-light">
    <form id="regForm" action="registerUser" method="post">
      <h1>User Registration</h1>
      <hr>
		<span>${msg}</span>
      <div class="form-group mt-1">
        <label for="uname">Name:</label>
        <input type="text" name="uname" id="uname" placeholder="Enter Username" class="form-control mt-1">
        <span id="nameEr" class="text-danger"></span>
      </div>

      <div class="form-group mt-1">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" placeholder="Enter Email" class="form-control mt-1">
        <span id="emailEr" class="text-danger"></span>
      </div>

      <div class="form-group mt-1">
        <label for="pass">Password:</label>
        <input type="password" name="pass" id="pass" placeholder="Enter Password" class="form-control mt-1">
        <span id="passEr" class="text-danger"></span>
      </div>

      <div class="form-group mt-1">
        <label for="cpass">Confirm Password:</label>
        <input type="password" name="cpass" id="cpass" placeholder="Confirm Password" class="form-control mt-1">
        <span id="cpassEr" class="text-danger"></span>
      </div>

      <div class="form-group mt-2">
        <input type="submit" name="subtn" value="Register" class="btn btn-success">
        <input type="reset" name="resbtn" value="Reset" class="btn btn-warning">
      </div>
    </form>
  </div>
</div>

</body>
</html>
