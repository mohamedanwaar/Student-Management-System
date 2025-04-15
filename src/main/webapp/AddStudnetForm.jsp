<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Students Tracker App</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <form action="StudentControllerServlet" method="get">
            <input type="hidden" name="command" value="ADD">
            <c:if test="${not empty errorMessage}">
                <div class="error-message">${errorMessage}</div>
            </c:if>
            <table>
                <tbody>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" required></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>GPA:</td>
                    <td><input type="number" step="0.01" min="0" max="4" name="gpa" required></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="buttoom" type="submit" value="Add Student">
                        <input class="buttoom" type="button" value="Cancel" onclick="location.href='StudentControllerServlet'">
                    </td>
                </tr>
                </tbody>

            </table>

        </form>
    </div>


</div>
</body>
</html>