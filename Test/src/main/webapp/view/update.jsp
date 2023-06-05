<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2023
  Time: 6:47 PM
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
        <div class="row" style="">
            <div class="col-md-12">
                <h2>Product List </h2>
                <button type="button" class="btn btn-primary">
                    <a style="color: white; text-decoration: none" href="/product?action=list">Back</a>
                </button>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form action="/product" method="post">
                    <table>
                        <tr>
                            <td>Id: </td>
                            <td><input type="number" name="id" value="${requestScope["product"].getId()}"/></td>
                        </tr>
                        <tr>
                            <td>Name: </td>
                            <td><input type="text" name="name" value="${requestScope["product"].getName()}"/></td>
                        </tr>
                        <tr>
                            <td>Price: </td>
                            <td><input type="number" name="price" value="${requestScope['product'].getPrice()}"/></td>
                        </tr>
                        <tr>
                            <td>Quantity:</td>
                            <td><input type="number" name="quantity" value="${requestScope["product"].getQuantity()}"></td>
                        </tr>
                        <tr>
                            <td>Color:</td>
                            <td><input type="text" name="color" value="${requestScope["product"].getColor()}"></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><input type="text" name="description" value="${requestScope["product"].getDescription()}"></td>
                        </tr>
                        <tr>
                            <td>Categories:</td>
                            <td>
                                <select name="categories">
                                    <option value="Phone">Phone</option>
                                    <option value="Laptop">Laptop</option>
                                    <option value="TV">TV</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Update"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="action" value="update"/>
                </form>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
</body>
</html>
