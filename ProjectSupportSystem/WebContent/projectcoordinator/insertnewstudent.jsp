<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/styles/projectcoordinator.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script type="text/javascript" src="resources/scripts/insertProgress.js">
	
</script>

<title>BIT-University of Colombo School of Computing - Project
	Evaluation Support System</title>

</head>
<body>
	
	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_leftSideBarCoordinator.jsp" />
	
	<div id="loginedUser">
		<p>You are logged in as: ${user.userName}</p>
	</div>
	<div class="container-fluid" id="formload">
		<div id="dashboard">
		<form class="form-horizontal" action="InsertNewStudentList" method="POST" enctype="multipart/form-data">
		<c:if test="${param.success eq 0}">
				<div class="alert alert-danger">
					<strong> Something went Wrong !</strong>
				</div>
		</c:if>
		<c:if test="${param.success eq 1}">
				<div class="alert alert-success">
					<strong> Student list has been successfully inserted !</strong>
				</div>
		</c:if>
			<button type="button" class="btn btn-primary col-sm-12" data-target=""> New Student Insertion </button>
			<p> *Upload the excel file </p>
			<div class="form-group">
					<label for="Inputform" class="col-sm-12 control-label">Submit
						Form: </label>
					<div class="col-sm-12">
						<input type="file" name="studentlist" required>
						<p class="help-block col-sm-3"> Excel file should be in the following format </p>
					</div>
				</div>
			<button class="btn" type="submit"> Submit </button> 
		</form>
		</div>
	</div>
	
</body>
</html>
