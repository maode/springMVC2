<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><spring:message code="msg.addStu"/></title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="form-container">
 	<h1><spring:message code="msg.addStu" /></h1>
	<form:form method="POST" action="/student" modelAttribute="student" class="form-horizontal">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstName"><spring:message code="msg.firstName"/></label>
				<div class="col-md-7">
					<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastName"><spring:message code="msg.lastName"/></label>
				<div class="col-md-7">
					<form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="sex"><spring:message code="msg.sex"/></label>
				<div class="col-md-7" class="form-control input-sm">
					<form:radiobutton path="sex" value="M" />Male 
	    			<form:radiobutton path="sex" value="F" />Female
					<div class="has-error">
						<form:errors path="sex" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="num"><spring:message code="msg.number"/></label>
				<div class="col-md-7">
					<form:input type="text" path="num" id="num" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="num" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="dob"><spring:message code="msg.birthdate"/></label>
				<div class="col-md-7">
					<form:input type="text" path="dob" id="dob" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="dob" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="email"><spring:message code="msg.email"/></label>
				<div class="col-md-7">
					<form:input type="text" path="email" id="email" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="email" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="grade"><spring:message code="msg.grade"/></label>
				<div class="col-md-7" class="form-control input-sm">
					<form:radiobuttons path="grade" items="${grades}" />
					<div class="has-error">
						<form:errors path="grade" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="country"><spring:message code="msg.country"/></label>
				<div class="col-md-7">
					<form:select path="country" id="country" class="form-control input-sm">
				        <form:option value="">Select Country</form:option>
			    	    <form:options items="${countries}" />
				    </form:select>
					<div class="has-error">
						<form:errors path="country" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstAttempt"><spring:message code="msg.firstAttempt"/> ?</label>
				<div class="col-md-1">
					<form:checkbox path="firstAttempt" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstAttempt" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
	

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="subjects"><spring:message code="msg.subjects"/></label>
				<div class="col-md-7">
					<form:select path="subjectStr" itemLabel="name" itemValue="id" items="${subjects}" multiple="true" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="subjectStr" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="has-error">
				${errorMsg }
			</div>
			<div class="form-actions floatRight">
				<input type="submit" value='<spring:message code="msg.add"/>' class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>