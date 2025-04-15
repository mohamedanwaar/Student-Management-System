<%--
  Created by IntelliJ IDEA.
  User: mmoha
  Date: 4/14/2025
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <input type="hidden" name="command" value="UPDATE">
            <input type="hidden" name="studentId" value="${THE_STUDENT.id}">
            <c:if test="${not empty errorMessage}">
                <div class="error-message">${errorMessage}</div>
            </c:if>
            <table>
                <tbody>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="firstName" value="${THE_STUDENT.firstName}"></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" value="${THE_STUDENT.lastName}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" value="${THE_STUDENT.email}" ></td>
                </tr>
                <tr>
                    <td>GPA:</td>
                    <td><input type="number" step="0.01" name="gpa" value="${THE_STUDENT.gpa}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="buttoom" type="submit" value="Update Student">
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