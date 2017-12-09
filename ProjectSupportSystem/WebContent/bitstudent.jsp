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
	<div class="container-fluid"> 
		<div class="row">
		<div class="col-md-10">
			<div class="row">
				<div ng-app="myApp" ng-controller="viewMessages" class="container" id="area">
				<div class="changer" id="formload" ng-repeat="y in myArray">
					<div class="container-fluid" >
    					<div class="well well-lg">
							<h3 class="text-primary">{{y.header}}</h3>
							<br/>
							<br/>
							<br/>
							<p class="text-primary float-sm-right">Posted by:{{y.UserName}}<p><br/>
							
							<!-- <p class="text-primary float-right"> On:: Date & Time </p> -->
							<p class="text-primary">{{y.detail}}</p> 
							
					
						</div>
						
					</div>
					
			
				</div>
				
</div>	
			</div>
		</div>
		<div class="col-md-2 offset-md-10">
				<div class="row" class="embed-responsive embed-responsive-1by1">
					<iframe class="embed-responsive-item" src="https://calendar.google.com/calendar/embed?showTitle=0&amp;showNav=0&amp;showPrint=0&amp;showTabs=0&amp;showCalendars=0&amp;showTz=0&amp;height=250&amp;wkst=2&amp;bgcolor=%23ccccff&amp;src=ims7tt4rafv310dvju5bj73gvg%40group.calendar.google.com&amp;color=%23B1440E&amp;ctz=Asia%2FColombo" 
					style="border:solid 1px #777" width="250" height="250" scrolling="no"  ></iframe> 
				</div>
				<div class="row">
					<div class="well">
					<p>You've submitted:
					<div>Supervisor Agreement form <span class="badge">5</span></div>
					<div>Client agreement form <span class="badge">5</span></div>
					<div>Project proposal <span class="badge">5</span></div>
					<div>Progress reports <span class="badge">5</span></div>
					<div>Interim reports <span class="badge">5</span></div>
					</p>
					</div>
				
				</div>
		</div>
		</div>
	</div>
				
</body>
</html>
