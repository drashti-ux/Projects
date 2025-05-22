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
<div class="bg-overlay">
  <div class="container content">
    <!-- Centered content block -->
    <div class="d-flex flex-column align-items-center justify-content-center text-center mt-5">

      <!-- 🖼️ Add Image Here -->
      <img src="cals.avif" alt="Expense Tracker" class="img-fluid mb-4" style="max-width: 400px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0,0,0,0.5);">

      <!-- Heading -->
      <h1 class="display-4 fw-bold text-uppercase mb-4" style="text-shadow: 2px 2px 4px rgba(0,0,0,0.6); letter-spacing: 2px;">
        Welcome to Expense Tracker
      </h1>

      <!-- Paragraphs -->
      <p class="fs-5 fst-italic mb-3" style="text-shadow: 1px 1px 2px rgba(0,0,0,0.5); color: #f8f9fa;">
        Ready to see where your money's going? Track what you spend, stay on top of bills, and crush your savings goals all in one place.
      </p>
      <p class="fs-5 fst-italic mb-3" style="text-shadow: 1px 1px 2px rgba(0,0,0,0.5); color: #f8f9fa;">
        Stay on top of your finances with ease.sRecord your expenses, categorize them, and view insights to help you manage your money better.
      </p>
      <p class="fs-6 text-light fw-semibold" style="letter-spacing: 1px;">
        Super easy. Totally yours. <a href="registerUser.jsp" >Start now..</a> 
      </p>
    </div>
  </div>
</div>

<!-- Bootstrap JS CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>