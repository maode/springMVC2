<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
			<td><a href="<c:url value='/student/${student.id}/edit' />" >edit</a></td>
			<td><a href="###"  data-del="${student.id }">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/student/add' />">Add New Student</a>

<script type="text/javascript" src="/static/lib/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="/static/lib/jquery.rest.js"></script>
<script>
$(function(){
//start	
	//删除学生
	$("a[data-del]").on("click",function(){
		alert(2);
		var id=$(this).attr("data-del");
		$.rest.remove({
			url:"/student/",
			data:{id:id},
			success:function(result){
				if(result&&result.success===true){
					$(this).parent("tr").remove();
				}else{
					alert("删除失败");
				}
			}
		});
	});
//end	
});
</script>
</body>
</html>