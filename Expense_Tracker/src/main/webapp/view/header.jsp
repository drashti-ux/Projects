<%-- <%@ page contentType="text/html;charset=UTF-8" %> --%>
<%@ page import="com.model.User" %>
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

<%
    User user = (User) session.getAttribute("username");
    boolean isLoggedIn = (user != null);
%>
<script type="text/javascript" src="Validations.js"></script>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
    body {
        background: url('images/bg.jpg') no-repeat center center fixed;
        background-size: cover;
        background-repeat: no-repeat;
        color: white;
        /* To avoid navbar overlap */
    }

    .bg-overlay {
        background-color: rgba(0, 0, 0, 0.6); /* dark overlay for text readability */
        min-height: 100vh;
        padding-top: 70px;
    }

    .navbar-custom {
        background-color: rgba(0, 0, 0, 0.7);
        z-index: 2;
    }

    .navbar-brand, .nav-link {
        color: white !important;
    }
</style>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
    <div class="container-fluid ">
        <a class="navbar-brand" href="index.jsp">ExpenseTracker</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <% if (isLoggedIn) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="/Expense_Tracker/view/dashbord">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Expense_Tracker/view/transactions">Transactions</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/Expense_Tracker/view/logout">Logout</a>
                    </li>
                <% } else { %>
                    <li class="nav-item">
                        <a class="nav-link active" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>