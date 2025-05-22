<%@page import="com.model.User"%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    User u = (User) session.getAttribute("username");
%>

<html>
<head>
    <title>Expense Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <%@ include file="header.jsp" %> <!-- Navbar Include -->

    <div class="container mt-5">
        <!-- Welcome Message -->
        <div class="text-center mb-4 mt-5 pt-5 text-dark" style="margin-top: 100px;">
            <!-- Adjusted the margin-top to move it down -->
            <h2 class=" fw-bold"  style="font-family: 'sans-serif'"> Welcome, <%= u.getUname() %> 👋</h2>
            <p>Here’s a summary of your financial activity</p>
        </div>

        <!-- Financial Overview -->
        <div class="row text-center mb-4">
            <div class="col-md-4">
                <div class="card p-3 shadow-sm">
                    <h5>Total Income</h5>
                    <p class="text-success fw-bold">${income}</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-3 shadow-sm">
                    <h5>Total Expenses</h5>
                    <p class="text-danger fw-bold">${expense}</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-3 shadow-sm">
                    <h5>Current Balance</h5>
                    <p class="text-primary fw-bold">${income - expense}</p>
                </div>
            </div>
        </div>

        <!-- Action Buttons -->
        <div class="text-center mb-5">
            <a href="transaction.jsp?type=income" class="btn btn-success btn-lg me-3">➕ Add Income</a>
            <a href="transaction.jsp?type=expense" class="btn btn-danger btn-lg">➖ Add Expense</a>
        </div>

        <!-- Recent Transactions -->
        <div>
            <h4 class="mb-3 text-dark text-shadow">Recent Transactions</h4>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Category</th>
                        <th>Amount (₹)</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="t" items="${trans}">
                   	<tr>
                   	 <td>${t.getDate()}</td>
                   	 <td>${t.getType()}</td>
                   	 <td>${t.getCategory()}</td>
                   	 <td>${t.getAmount()}</td>
                   	 <td>${t.getNote()}</td>
                   	</tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
