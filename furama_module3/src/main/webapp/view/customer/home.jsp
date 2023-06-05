<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/5/2023
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
</head>
<body>
<%-- lock --%>
<div class="container-fluid">
    <div class="header-top">
        <div class="row">
            <div class="col-md-3 text-center">
                LOGO
            </div>
            <div class="col-md-6"></div>
            <div class="col-md-3 text-center">
                HIEUBEE
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="row">
            <div class="col-md-3">
            </div>
            <div class="col-md-5 text-center">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="#">Home</a>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-item nav-link" href="#">Employee</a>
                            <a class="nav-item nav-link" href="#">Customer</a>
                            <a class="nav-item nav-link" href="#">Service</a>
                            <a class="nav-item nav-link" href="#">Contract</a>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="col-md-4 text-center">
                <nav class="navbar navbar-light justify-content-between">
                    <form class="form-inline" style="margin: 0px">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" style="display: inline-block; width: auto">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </nav>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="row">
            <div class="col-md-2">
                <a href="/home?action=create">Add new product</a>
            </div>
            <%-- lock --%>
            <div class="col-md-10">
                <div class="table-customer" style="padding: 50px 30px 50px 10px;">
                    <table class="table">
                        <thead class="thead-dark" style="background: #198754; color: white">
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">CustomerType</th>
                            <th scope="col">Name</th>
                            <th scope="col">Birthday</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Id Card</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Address</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${customers}" var="c">
                            <tr>
                                <th scope="row">${c.id}</th>
                                <td>${c.idCustomerType}</td>
                                <td style="width: 25%">${c.name}</td>
                                <td style="width: 10%">${c.birthday}</td>
                                <td>
                                    <c:if test="${c.gender}">
                                        Nữ
                                    </c:if>
                                    <c:if test="${!c.gender}">
                                        Nam
                                    </c:if>
                                </td>
                                <td>${c.idCard}</td>
                                <td>${c.phone}</td>
                                <td style="width: 15%">${c.email}</td>
                                <td style="width: 15%">${c.address}</td>
                                <td>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detail${c.id}">
                                        Detail
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#${c.id}">
                                        Delete
                                    </button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-secondary">
                                        <a style="color: white; text-decoration: none" href="/home?action=update&id=${c.id}">Update</a>
                                    </button>
                                </td>
                            </tr>
                            <%-- Delete --%>
                            <div class="modal fade" id="${c.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">
                                                <a style="color: white" href="/home?action=delete&id=${c.id}">Delete</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%-- End delete --%>
                            <%-- Detail --%>
                            <div class="modal fade" id="detail${c.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabelDetail">Customer detail</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <span style="font-weight: bold">Id:</span> ${c.id} <br>
                                            <span style="font-weight: bold">Customer Type:</span> ${c.idCustomerType} <br>
                                            <span style="font-weight: bold">Name:</span> ${c.name} <br>
                                            <span style="font-weight: bold">Birthday:</span> ${c.birthday} <br>
                                            <span style="font-weight: bold">Gender:</span> ${c.gender} <br>
                                            <span style="font-weight: bold">Id card:</span> ${c.idCard} <br>
                                            <span style="font-weight: bold">Phone:</span> ${c.phone} <br>
                                            <span style="font-weight: bold">Email:</span> ${c.email} <br>
                                            <span style="font-weight: bold">Address:</span> ${c.address} <br>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%-- End detail --%>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/bootstrap/bootstrap.bundle.min.js">
</script>
</html>
