<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="showAddForm" method="get">
    <input type="submit" value="Add Student"/>
</form>
<H2>List Of Students</H2>
<table>
    <tr>
        <th>First Name </th><th> Last Name </th><th> Email </th><th> Action</th></tr>
    <jsp:useBean id="students" scope="request" type="java.util.List"/>
    <c:forEach var="TempStudent" items="${students}">
    <c:url var="updateLink" value="showEditForm">
        <c:param name="studentId" value = "${TempStudent.id }"/>
    </c:url>
    <c:url var="deleteLink" value="deleteStudent">
    <c:param name="studentId" value = "${TempStudent.id }"/>
    </c:url>
        <tr>
            <td> ${TempStudent.firstName}</td>
            <td> ${TempStudent.lastName}</td>
            <td>${TempStudent.email}</td>
            <td> <a href="${updateLink}">Edit </a>| <a href="${deleteLink}">Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>