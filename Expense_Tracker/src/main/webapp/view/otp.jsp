<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
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

            <form action="varifyOtp" id="varify" method="post">
                <h1 class="text-center mb-3 text-dark">Otp Varification</h1>
                <hr>
				<span class="text-danger text-center"><h4>${msg}</h4></span>
                <div class="form-group mt-2">
                    <label for="otp" class="text-dark">otp:</label>
                    <input type="otp" name="otp" id="otp" placeholder="Enter otp Sent on Your Email" class="form-control mt-1">
                    <span id="otpErr" class="text-danger"></span>
                </div>

                <div class="form-group mt-4 d-flex ">
                    <input type="submit" name="subtn" value="varify" class="btn btn-success">
                   
                </div>
                
            </form>

        </div>
    </div>
</div>
</body>
</html>
