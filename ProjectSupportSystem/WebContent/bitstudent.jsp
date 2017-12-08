<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>BIT-University of Colombo School of Computing - Project
	Evaluation Support System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/styles/bitstudent.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript" src="resources/scripts/bitstudent.js"></script>

</head>
<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_leftSideBarStudent.jsp"/>
	<div id="loginedUser"> <p>You are logged in as: ${user.userName} </p></div>
	<div ng-app="myApp" ng-controller="viewMessages" class="container" id="area">
	<div class="changer" id="formload" ng-repeat="y in myArray">
		<div class="container">
			<div class="jumbotron">
				<div> {{y.detail}}</div>
				<div> header:: {{y.header}} </div>
			</div>
		</div>
			
	</div>
	</div>
	


</body>
</html>
