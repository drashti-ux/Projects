<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expense Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            overflow-x: hidden;
        }
    </style>
</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="container mt-5 pt-4">
        <h4 class="text-dark">All Transactions</h4>
        <div class="table-responsive">
            <table class="table table-bordered mt-3">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Category</th>
                        <th>Amount (₹)</th>
                        <th>Note</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="t" items="${trs}">
                    <tr>
                        <td>${t.getDate()}</td>
                        <td>${t.getType()}</td>
                        <td>${t.getCategory()}</td>
                        <td>${t.getAmount()}</td>
                        <td>${t.getNote()}</td>
                        <td><a href="deleteTr?did=${t.getTr_id()}" class="btn btn-danger">Delete</a></td>
                        <td><a href="updateTr?eid=${t.getTr_id()}" class="btn btn-primary">Update</a></td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

  <script>
    document.addEventListener("DOMContentLoaded", function () {

        // DELETE CONFIRMATION
        document.querySelectorAll(".btn-danger").forEach(btn => {
            btn.addEventListener("click", function (e) {
                const confirmed = confirm("Are you sure you want to delete?");
                if (!confirmed) {
                    e.preventDefault();
                }
            });
        });

        // UPDATE & SAVE FUNCTIONALITY
        document.querySelectorAll(".btn-primary").forEach(btn => {
            btn.addEventListener("click", function (e) {
                e.preventDefault();
                const row = this.closest("tr");

                const updateBtn = this;
                const deleteBtn = row.querySelector(".btn-danger");

                if (updateBtn.textContent === "Update") {
                    const originalValues = [];

                    // Make columns editable and store original values
                    row.querySelectorAll("td").forEach((td, index) => {
                        if (index < 5) {
                            originalValues.push(td.textContent.trim());
                            const input = document.createElement("input");
                            input.type = "text";
                            input.className = "form-control";
                            input.value = td.textContent.trim();

                            // Assign name based on column index
                            switch (index) {
                                case 0: input.name = "date"; break;
                                case 1: input.name = "type"; break;
                                case 2: input.name = "category"; break;
                                case 3: input.name = "amount"; break;
                                case 4: input.name = "note"; break;
                            }

                            td.innerHTML = "";
                            td.appendChild(input);
                        }
                    });

                    // Replace Delete with Cancel
                    const cancelBtn = document.createElement("button");
                    cancelBtn.className = "btn btn-secondary";
                    cancelBtn.textContent = "Cancel";
                    deleteBtn.parentElement.replaceChild(cancelBtn, deleteBtn);

                    // Replace Update with Save
                    updateBtn.textContent = "Save";
                    updateBtn.classList.remove("btn-primary");
                    updateBtn.classList.add("btn-success");

                    // Cancel functionality
                    cancelBtn.addEventListener("click", function () {
                        row.querySelectorAll("td").forEach((td, index) => {
                            if (index < 5) {
                                td.textContent = originalValues[index];
                            }
                        });

                        // Restore buttons
                        const newDeleteBtn = document.createElement("a");
                        newDeleteBtn.href = deleteBtn.href;
                        newDeleteBtn.className = "btn btn-danger";
                        newDeleteBtn.textContent = "Delete";
                        cancelBtn.parentElement.replaceChild(newDeleteBtn, cancelBtn);

                        updateBtn.textContent = "Update";
                        updateBtn.classList.remove("btn-success");
                        updateBtn.classList.add("btn-primary");
                    });

                } else if (updateBtn.textContent === "Save") {
                    const inputs = row.querySelectorAll("input");

                    const form = document.createElement("form");
                    form.method = "post";
                    form.action = "updateTr";

                    const trId = new URL(updateBtn.href).searchParams.get("eid");
                    const idInput = document.createElement("input");
                    idInput.type = "hidden";
                    idInput.name = "tr_id";
                    idInput.value = trId;
                    form.appendChild(idInput);

                    inputs.forEach(input => {
                        const hidden = document.createElement("input");
                        hidden.type = "hidden";
                        hidden.name = input.name;
                        hidden.value = input.value;
                        form.appendChild(hidden);
                    });

                    document.body.appendChild(form);
                    form.submit();
                }
            });
        });
    });
</script>



</body>
</html>
