<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/5/2023
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
      <%@include file="view/customer/bootstrap.min.css"%>
    </style>
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
            NAME
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
          <div class="col-md-4">
            <a href="/product?action=create">Add new product</a>
          </div>
<%-- lock --%>
          <div class="col-md-8">
            <table>
              <tr>
                <th>Id</th>
                <th>Customer Type</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Id Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th></th>
              </tr>
              <c:forEach items="${customers}" var="c">
                <tr>
                  <td>${c.id}</td>
                  <td>${c.idCustomerType}</td>
                  <td>${c.name}</td>
                  <td>${c.birthday}</td>
                  <td>${c.gender}</td>
                  <td>${c.idCard}</td>
                  <td>${c.phone}</td>
                  <td>${c.email}</td>
                  <td>${c.address}</td>
                  <td><a href="/product?action=detail&id=${c.id}">Detail</a></td>
                  <td><a href="/product?action=update&id=${c.id}">Update</a></td>
                </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
<script src="view/customer/bootstrap.bundle.min.js">
</script>
</html>
