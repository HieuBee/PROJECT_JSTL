<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2023
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="header">
        <div class="row" style="padding-bottom: 50px;">
            <div class="col-md-12">
                <h2>Product List</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form action="/product?action=search" method="post" style="display: inline-block">
                    <input type="text" placeholder="Input here ....." name="search">
                    <input type="submit" value="Search">
                </form>
                <button type="button" class="btn btn-primary">
                    <a style="color: white; text-decoration: none" href="/product?action=create">Add new product</a>
                </button>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="row">
            <%-- lock --%>
            <div class="col-md-10">
                <div class="table-customer" style="padding: 50px 30px 50px 10px;">
                    <table class="table">
                        <thead class="thead-dark" style="background: #198754; color: white">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Color</th>
                            <th scope="col">Description</th>
                            <th scope="col">Categories</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${products}" var="p">
                            <tr>
                                <th scope="row">${p.id}</th>
                                <td>${p.name}</td>
                                <td>${p.price}</td>
                                <td>${p.quantity}</td>
                                <td>${p.color}</td>
                                <td>${p.description}</td>
                                <td>${p.categories}</td>
                                <td>
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#${p.id}">
                                        Delete
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-secondary">
                                        <a style="color: white; text-decoration: none" href="/product?action=update&id=${p.id}">Update</a>
                                    </button>
                                </td>
                            </tr>
                            <%-- Delete --%>
                            <div class="modal fade" id="${p.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Do you want to product id: <span style="font-weight: bold">${p.id}</span> ?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">
                                                <a style="color: white" href="/product?action=delete&id=${p.id}">Delete</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%-- End delete --%>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/bootstrap/bootstrap.bundle.min.js"></script>
</html>
