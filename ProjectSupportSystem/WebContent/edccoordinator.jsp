<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title> BIT-University of Colombo School of Computing - Project Evaluation Support System </title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/edccoordinator.css"/> 	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script type="text/javascript" src="resources/scripts/payment.js"></script>
<title> BIT-University of Colombo School of Computing - Project Evaluation Support System </title>
</head>
<body>
 	
	<jsp:include page="_header.jsp"/> 

	 <!-- Left Side Navigation bar-->

	</div class="left-side-bar">
	 	<div class="container-fluid">
	 		<div class="row">	
				<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
	         	 <ul class="nav nav-pills flex-column">
	          	  <li class="nav-item">
	              <a class="nav-link active" href="#" onclick="loadStudent()">Add New</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#" onclick="loadPayment()">Add Payment</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Search</a>
	            </li>
	           </ul>

	          <!--<ul class="nav nav-pills flex-column">
	            <li class="nav-item">
	              <a class="nav-link" href="#">Nav item</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Nav item again</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">One more nav</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Another nav item</a>
	            </li>
	          </ul>

	          <ul class="nav nav-pills flex-column">
	            <li class="nav-item">
	              <a class="nav-link" href="#">Nav item again</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">One more nav</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Another nav item</a>
	            </li>
	          </ul> -->
	        </nav>
	       </div>
	      </div>

		
	 <!-- Form   -->

	<div class="input-data" id="formload">
	<div id="student">
	<form class="form-horizontal" method="POST" action="DoInsertStudent">
		<center><h4> Student Details </h4> </center>
	 	<div class="form-group">
	    	<label for="InputStudentId" class="col-sm-3 control-label">StudentID: </label>
	    	<div class="col-sm-9"><input type="text" class="form-control" name="studentId" placeholder="ID"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputFirstName" class="col-sm-3 control-label">First Name:</label>
	    	<div class="col-sm-9"><input type="text" class="form-control" name="firstName" placeholder="First Name"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputLastName" class="col-sm-3 control-label">Last Name:</label>
	    	<div class="col-sm-9"><input type="text" class="form-control" name="lastName" placeholder="Last Name"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputLastName" class="col-sm-3 control-label">NIC:</label>
	    	<div class="col-sm-9"><input type="text" class="form-control" name="nic" placeholder="NIC"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputEmail" class="col-sm-3 control-label">E-Mail:</label>
	    	<div class="col-sm-9"><input type="email" class="form-control" name="email" placeholder="E-Mail"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputAddress" class="col-sm-3 control-label">Address:</label>
	    	<div class="col-sm-9"><textarea class="form-control" name="address" rows="3" placeholder="No,Street Name,City Name"></textarea> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputTeleNo" class="col-sm-3 control-label">Mobile:</label>
	    	<div class="col-sm-9"><input type="text" class="form-control" name="mobileNo" placeholder="Mobile No"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputDOB" class="col-sm-3 control-label">DOB:</label>
	    	<div class="col-sm-9"><input type="date" class="form-control" name="dob"> </div>
	  	</div>
	  	<div class="form-group">
	    	<label for="InputGender" class="col-sm-3 control-label">Gender:</label>
	    	<div class="col-sm-9"><select class="form-control" name="gender"> <option> Male</option> <option>Female </option>	</select></div>
	  	</div>
	  		
	  	<button class="btn btn-default">Review</button>
	  	<button type="submit" class="btn btn-default">Save</button>
	</form>
	</div>
	</div>
</body>
</html>