<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.projectsupport.services.SystemUtilServices"%>
<%@ page import="com.projectsupport.services.MyUtils"%>
<%@ page import="com.projectsupport.services.ProgressReportServices"%>
<%@ page import="com.projectsupport.models.FormSub"%>
<%@ page import="com.projectsupport.models.ProgressReportSub"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.time.LocalTime"%>
<%@ page import="java.time.Duration"%>
<!DOCTYPE html>
<html>
<head>
<style>

body {
    font-family: "Lato", sans-serif;
}
.sidenav {
	margin-top:132px;
    height:100%;
    width: 150px;
    position:fixed;
    z-index:1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    padding-top: 50px;
   
}

.sidenav a {
    padding: 6px 6px 6px 32px;
    text-decoration: none;
    font-size: 20px;
    color: #818181;
    display: block;
}

.sidenav a:hover{
    color: #f1f1f1;
}

.sidenav a:active{
	color:#f1f1f1;
}

.main {
    margin-left: 200px; /* Same as the width of the sidenav */
}


@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
</style>
</head>
<body>

<div class="sidenav">
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

</body>
</html> 