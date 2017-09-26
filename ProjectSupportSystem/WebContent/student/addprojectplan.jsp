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


</head>
<body>

	<jsp:include page="../_header.jsp" />
	<jsp:include page="../_leftSideBarStudent.jsp" />

	<div id="loginedUser">
		<p>You are logged in as: ${user.userName}</p>
	</div>
	<div class="changer" id="formload">
		<div id="plan">
			<form class="form-horizontal" method="POST"
				action="DoAddProjectPlan">
				<c:if test="${param.success eq 1}">
					<div class="alert alert-success">
						<strong>Successfully Deleted !</strong>
					</div>
				</c:if>
				<c:if test="${param.success eq 0}">
					<div class="alert alert-warning">
						<strong>Successfully Updated !</strong>
					</div>
				</c:if>
				<center>
					<h4>Project Plan</h4>
				</center>
				
				<div class="form-group"">
					<table class="table table-bordered">
						<thead>
							<tr class="warning">
								<th>Step</th>
								<th>Starting-Date</th>
								<th>Ending Date</th>
							</tr>
						</thead>
						<tbody>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr1">
										<option>Find a project and meet client</option>
								</select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="sdate1" name="sdate1"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate1"></td>
								

								
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr2">
										<option>Feasibility Study</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="date2"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input"  name="edate2"></td>
								
										<!-- <option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option>
 -->
								
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr3">
										<option>Gather client requirements </option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate3"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input"  name="edate3"></td>
								
										<!-- <option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option>
 -->
								
							</tr>
							<tr class="info">
							<td class="col-sm-6"><select class="form-control" name="pr4">
										<option>Define scope</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate4"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input"  name="edate4"></td>
								
										<!-- <option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option> -->

								
							</tr>
							<tr class="info">
							<td class="col-sm-6"><select class="form-control" name="pr5">
										<option>Define users and use cases</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate5"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate5"></td>
								
								<!-- 		<option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option>

								</select></td> -->
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr6">
										<option>Requirement Analysis</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate6"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate6"></td>
								
									<!-- 	<option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option>

								</select></td> -->
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr7">
										<option>UI-Design</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate7"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate7"></td>
								
										<!-- <option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>
										<option>Testing</option>

								</select></td> -->
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr8">
										<option>UI-Development</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate8"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate8"></td>
								
									<!-- 	<option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>Back-end Development</option>
										<option>Testing</option>

								</select></td> -->
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr9">
										<option>Back-end Development</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate9"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate9"></td>
								
									<!-- 	<option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Testing</option>

								</select></td> -->
							</tr>
							<tr class="info">
								<td class="col-sm-6"><select class="form-control" name="pr10">
										<option>Testing</option></select></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="sdate10"></td>
								<td class="col-sm-3"><input class="form-control"
									type="date" id="example-date-input" name="edate10"></td>
								
									<!-- 	<option>Feasibility Study</option>
										<option>Find a project and meet client</option>
										<option>Gather client requirements</option>
										<option>Define scope</option>
										<option>Define users and use cases</option>
										<option>Requirement Analysis</option>
										<option>Client Feedback</option>
										<option>UI-Design</option>
										<option>UI-Development</option>
										<option>Back-end Development</option>


								</select></td> -->
							</tr>

						</tbody>
					</table>
				</div>
				<button type="submit" class="btn btn-default">Save</button>
			</form>
		</div>
	</div>