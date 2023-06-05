<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/6/2023
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/RentalRoom?action=create" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="number" name="phone"></td>
            </tr>
            <tr>
                <td>BorrowDate:</td>
                <td><input type="date" name="borrowDate"></td>
            </tr>
            <tr>
                <td>Payment:</td>
                <td>
                    <select name="payment">
                        <option value="Monthly">Monthly</option>
                        <option value="Season">Season</option>
                        <option value="Yearly">Yearly</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><input type="text" name="note"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>
        <input type="hidden" name="action" value="create"/>
    </form>
</body>
</html>
