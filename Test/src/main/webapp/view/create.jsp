<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2023
  Time: 6:28 PM
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
                <h2>Product List</h2>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <form action="/product?action=create" method="post">
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td>Price:</td>
                            <td><input type="number" name="price"></td>
                        </tr>
                        <tr>
                            <td>Quantity:</td>
                            <td><input type="number" name="quantity"></td>
                        </tr>
                        <tr>
                            <td>Color:</td>
                            <td><input type="text" name="color"></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><input type="text" name="description"></td>
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
                            <td><input type="submit" value="Create"></td>
                        </tr>
                    </table>
                    <input type="hidden" name="action" value="create"/>
                </form>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
</body>
</html>
