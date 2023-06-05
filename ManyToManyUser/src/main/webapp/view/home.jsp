<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/5/2023
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="bootstrap.min.css"%>
    </style>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">FullName</th>
            <th scope="col">Code</th>
            <th scope="col">Birthday</th>
            <th scope="col">CreateTime</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u" >
        <tr>
            <th scope="row">${u.id}</th>
            <td>${u.fullName}</td>
            <td>${u.code}</td>
            <td>${u.birthday}</td>
            <td>${u.createTime}</td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detail${u.id}">
                    Detail
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#${u.id}">
                    Delete
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-secondary">
                    <a style="color: white; text-decoration: none" href="/home?action=update&id=${u.id}">Update</a>
                </button>
            </td>
        </tr>
        <%-- Delete --%>
        <div class="modal fade" id="${u.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                            <a style="color: white" href="/home?action=delete&id=${u.id}">Delete</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <%-- End delete --%>
        <%-- Detail --%>
        <div class="modal fade" id="detail${u.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabelDetail">Customer detail</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <span style="font-weight: bold">Id:</span> ${u.id} <br>
                        <span style="font-weight: bold">FullName:</span> ${u.fullName} <br>
                        <span style="font-weight: bold">Code:</span> ${u.code} <br>
                        <span style="font-weight: bold">Birthday:</span> ${u.birthday} <br>
                        <span style="font-weight: bold">CreateTime:</span> ${u.createTime} <br>
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
</body>
<script src="view/customer/bootstrap.bundle.min.js"></script>
</html>
