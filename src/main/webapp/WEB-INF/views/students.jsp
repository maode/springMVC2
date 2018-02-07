<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>学生列表</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Student</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Sex</td><td>Number</td><td>First Attempt</td><td>edit</td><td>delete</td>
		</tr>
		<c:forEach items="${students}" var="student">
			<tr>
			<td>${student.firstName}${student.lastName}</td>
			<td>${student.sex=='F' ? '女':'男'}</td>
			<td>${student.num}</td>
			<td>${student.firstAttempt}</td>
			<td><a href="<c:url value='/student/${student.id}' />">${student.num}</a></td>
			<td><a href="<c:url value='/student/${student.id}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/student' />">Add New Student</a>
</body>
</html>