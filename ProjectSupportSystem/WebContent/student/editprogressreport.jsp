<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BIT-University of Colombo School of Computing - Project
	Evaluation Support System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/styles/bitstudent.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/scripts/bitstudent.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript" src="resources/scripts/loadSubmission.js">
	
</script>


</head>
<body>

	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_leftSideBarStudent.jsp" />

	<div id="loginedUser">
		<p>You are logged in as: ${user.userName}</p>
	</div>
	<div class="changer" id="formload">
		<div id="progressReport1">
			<form class="form-horizontal" method="POST"
				action="DoEditProgressReport">
				<c:if test="${param.success eq 1}">
					<div class="alert alert-success">
						<strong>Successfully Updated! </strong>
					</div>
				</c:if>
				<c:if test="${param.success eq 0}">
					<div class="alert alert-warning">
						<strong> Something went wrong! </strong>
					</div>
				</c:if>

				<h4>PROGRESS REPORT NO ${reportNo} </h4>
				<h4>  ${timeRemainingProgress} </h4>
				<div ng-app="myApp" ng-controller="ProgressController">
				<div class="form-group col-sm-12">
					<input type="hidden" name="reportNo" id="reportNo" value="${reportNo}"/>
				</div>
					<div class="form-group col-sm-12">
						<label for="exampleTextarea">Work carried out between this
							meeting and previous meeting: </label> <select class="form-control"
							name="workCarried" ng-disabled="state" ng-init="state=true"
							required>
							<option>{{progressreport.workCarried}}</option>
							<option>Feasibility Study</option>
							<option>Find a project and meet client</option>
							<option>Gather client requirements</option>
							<option>Define scope</option>
							<option>Define users and use cases</option>
							<option>Requirement Analysis</option>
							<option>Client Feedback</option>
							<option>UI-Design</option>
							<option>UI-Development</option>
							<option>Back-end Development</option>
							<option>Testing</option>


						</select>
					</div>
					<div class="form-group col-sm-12">
						<label for="exampleTextarea">Describe the above task: </label>
						<textarea class="form-control" id="exampleTextarea" rows="3"
							name="description" ng-disabled="state" ng-init="state=true"
							required>{{progressreport.describe}}</textarea>
					</div>
					<div class="form-group col-sm-12">
						<label for="exampleTextarea">Problems Encountered: </label>
						<textarea class="form-control" id="exampleTextarea" rows="3"
							name="problems" ng-disabled="state" ng-init="state=true" required>{{progressreport.problems}}</textarea>
					</div>
					<div class="form-group col-sm-12">
						<label for="exampleTextarea">Planned work that were unable
							to carry out with reasons: </label>
						<textarea class="form-control" id="exampleTextarea" rows="3"
							name="workPlannedButNotDone" ng-disabled="state"
							ng-init="state=true" required>{{progressreport.workPlannedButNotDone}}</textarea>
					</div>
					<div class="form-group col-sm-12">
						<label for="exampleTextarea">Work planned until next
							meeting: </label> <select class="form-control" name="workPlanned"
							ng-disabled="state" ng-init="state=true" required>
							<option>{{progressreport.workPlanned}}
							<option>Testing</option>
							<option>Feasibility Study</option>
							<option>Find a project and meet client</option>
							<option>Gather client requirements</option>
							<option>Define scope</option>
							<option>Define users and use cases</option>
							<option>Requirement Analysis</option>
							<option>Client Feedback</option>
							<option>UI-Design</option>
							<option>UI-Development</option>
							<option>Back-end Development</option>


						</select>

					</div>


					<!-- 	<div class="form-group">
			<label for="Inputform" class="col-sm-2 control-label">Submit
				Form: </label>
			<div class="col-sm-9">
				<input type="file" name="agreementForm">
				<p class="help-block col-sm-3">"*filename:
					clientAgreementForm.pdf"</p>
			</div>
		</div>   -->


					<button type="submit" class="btn btn-default">Save</button>
					<a class="btn btn-default" ng-click="state=false">Edit</a> <a
						class="btn btn-default" href="DoDeleteProgressReport"> Delete</a>
				</div>
			</form>
		</div>

	</div>
</body>
</html>