<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="d-flex align-items-center">
		<div class="container p-5 card col-4 mx-auto bg-light"
			style="margin-top: 50px">
			<form id="transaction" action="transaction" method="post">
				<c:if test="${param.type == 'income'}">
					<h1>Add Income</h1>
				</c:if>
				<c:if test="${param.type == 'expense'}">
					<h1>Add Income</h1>
				</c:if>
				<hr>
				<input type="hidden" name="type" value="${param.type}">
				<div class="form-group mt-1">
					<label for="amount">Amount:</label> <input type="text"
						name="amount" id="amount" placeholder="Enter amount"
						class="form-control mt-1"> <span id="nameEr"
						class="text-danger"></span>
				</div>

				<div class="form-group mt-1">
					<label for="cat">Category:</label> <input type="text" name="cat"
						id="cat" placeholder="Enter Category" class="form-control mt-1">
					<span id="emailEr" class="text-danger"></span>
				</div>

				<div class="form-group mt-1">
					<label for="date">Date:</label> <input type="date" name="date"
						id="date" class="form-control mt-1"> <span id="passEr"
						class="text-danger"></span>
				</div>

				<div class="form-group mt-1">
					<label for="note">Note:</label> <input type="text" name="note"
						id="note" placeholder="note" class="form-control mt-1"> <span
						id="cpassEr" class="text-danger"></span>
				</div>

				<div class="form-group mt-2">
					<input type="submit" name="add"
						value="Add ${param.type == 'expense' ? 'Expense' : 'Income'}"
						class="btn btn-success">
					<button type="button"
						onclick="window.location.href='dashboard.jsp'"
						class="btn btn-secondary">Cancel</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>