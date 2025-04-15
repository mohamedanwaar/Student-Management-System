<%--
  Created by IntelliJ IDEA.
  User: mmoha
  Date: 4/13/2025
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Students Tracker App</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Students Tracker App</h2>
    </div>
</div>
<div id="container">
    <div id="content"></div>
<%--    buttom to add studnet--%>
    <input class="buttoom" type="button" value="Add Student" onclick="location.href='AddStudnetForm.jsp'"/>





    <table>
        <tr>
            <th>first name </th>
            <th>last name </th>
            <th>email </th>
            <th>GPA </th>
            <th>Action </th>
            <th>Delete </th>

        </tr>
       <c:forEach var="tempstudent" items="${STUDENT_LIST}">

           <c:url value="StudentControllerServlet" var="tempLink">
               <c:param name="command" value="LOAD"/>
               <%--        every link has a id for the student--%>
               <c:param name="studentId" value="${tempstudent.id}"/>
           </c:url>
           <c:url value="StudentControllerServlet" var="tempDelete">
               <c:param name="command" value="DELETE"/>
               <%--        every link has a id for the student--%>
               <c:param name="studentId" value="${tempstudent.id}"/>
           </c:url>
        <tr>
            <td> ${tempstudent.firstName} </td>
            <td> ${tempstudent.lastName}</td>
            <td>${tempstudent.email}</td>
            <td>${tempstudent.gpa}</td>
            <td> <button class="update-button"> <a href="${tempLink}">Update</a></button> </a> </td>
            <td> <button class="delete-button"  > <a href="${tempDelete}">Delete</a></button> </td>

        </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>