<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2023
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RentalRoom</title>
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="header">
        <div class="row" style="padding-bottom: 50px;">
            <div class="col-md-12">
                <h2>Rental Room List</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form action="/RentalRoom?action=search" method="post" style="display: inline-block">
                    <input type="text" placeholder="Input here ....." name="search">
                    <input type="submit" value="Search">
                </form>
                <button type="button" class="btn btn-primary">
                    <a style="color: white; text-decoration: none" href="/RentalRoom?action=create">Add new product</a>
                </button>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="row">
            <%-- lock --%>
            <div class="col-md-10">
                <div class="table-customer" style="padding: 50px 30px 50px 10px;">
                    <form action="/RentalRoom" method="post">
                        <input type="hidden" name="action" value="deleteALot">
                        <table class="table">
                            <thead class="thead-dark" style="background: #198754; color: white">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Phone</th>
                                <th scope="col">BorrowDate</th>
                                <th scope="col">Payment</th>
                                <th scope="col">Note</th>
                                <th scope="col"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${rentalRoom}" var="r">
                                <tr>
                                    <th scope="row">${r.id}</th>
                                    <td>${r.name}</td>
                                    <td>${r.phone}</td>
                                    <td>

                                        <fmt:parseDate value="${r.borrow_date}" pattern="yyyy-MM-dd" type="date" var="birthdayFormat"/>
                                        <fmt:formatDate value="${birthdayFormat}" pattern="dd/MM/yyyy"/>
                                    </td>
                                    <td>${r.payment}</td>
                                    <td>${r.note}</td>
                                    <td>
                                        <input type="checkbox" name="choose" value="${r.id}">
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#${r.id}">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                                <%-- Delete --%>
                                <div class="modal fade" id="${r.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Do you want to remove room id: <span style="font-weight: bold">${r.id}</span> ?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">
                                                    <a style="color: white" href="/RentalRoom?action=delete&id=${r.id}">Delete</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%-- End delete --%>
                            </c:forEach>
                            </tbody>
                        </table>
                        <input type="submit" class="btn btn-secondary" value="DeleteALot">
                        <input type="hidden" name="action" value="deleteALot">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/bootstrap/bootstrap.bundle.min.js">
</script>
</html>
