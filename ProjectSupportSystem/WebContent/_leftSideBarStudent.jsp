<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.projectsupport.services.SystemUtilServices" %>
<%@ page import="com.projectsupport.services.MyUtils" %>
<%@ page import="com.projectsupport.models.FormSub" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.Duration" %>
</div class="left-side-bar">
<div class="container-fluid">
	<div class="row">
		<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
		<ul class="nav nav-pills flex-column">
		<% 
				String errorString = null;
				Connection conn = MyUtils.getStoredConnection(request);
				List<FormSub> formList = null;
				try {
					formList = SystemUtilServices.findFormSub(conn);
					
				} catch (SQLException e){
					e.printStackTrace();
				}
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date currentdate = new Date();
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		        System.out.println(sdf1.format(cal.getTime()));
				
		        	for(int i=0;i<formList.size();i++){
					//System.out.println(formList.get(i).getEndDate().toString());
					if(formList.get(i).getFormType().equals("Supervisor Details")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							
							out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"FindSupervisor\">Supervisor Details </a></li>");
						}
						else if(d1.equals(currentdate)){
							LocalTime time = LocalTime.parse(formList.get(i).getEndDate());
							LocalTime currentTime = LocalTime.parse(sdf1.format(cal.getTime()));
							Duration dur = Duration.between(time, currentTime);
						}
						
					}
					if(formList.get(i).getFormType().equals("Client Details")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							LocalTime time = LocalTime.parse(formList.get(i).getEndTime());
							LocalTime currentTime = LocalTime.parse(sdf1.format(cal.getTime()));
							Duration dur = Duration.between(time, currentTime);
							System.out.println(dur.toMinutes());
							out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"FindClient\"> Client Details </a></li>");	
						}
						else if(d1.equals(currentdate)){
							
						}
					}
					if(formList.get(i).getFormType().equals("Project Proposal")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"FindProjectProposal\">Project Proposal</a></li>");
						}
					}
					if(formList.get(i).getFormType().equals("Interim Report")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"FindInterimReport\" >Interim Report</a></li>");
						}
						else if(d1.equals(currentdate)){
							
						}
					}
					if(formList.get(i).getFormType().equals("Dissertation")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"FindDissertation\">Dissertation</a></li>");
						}
						else if(d1.equals(currentdate)){
							
						}
					}
					if(formList.get(i).getFormType().equals("Dissertation")){
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = sdf.parse(formList.get(i).getEndDate());
						if(d1.after(currentdate)){
							out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"\" onclick=\"loadMedical(); return false;\"> Medical</a></li>");
						}
						else if(d1.equals(currentdate)){
							
						}
					}
				}
				
				
				
				
		
		%>
				<!-- <li class="nav-item"><a class="nav-link" href="FindSupervisor">
						Supervisor Details </a></li>
				
				<li class="nav-item"><a class="nav-link" href="FindClient">
						Client Details </a></li>
			
				<li class="nav-item"><a class="nav-link" href="FindProjectProposal">Project Proposal</a></li>
				<li class="nav-item"><a class="nav-link" href="FindProgressReport"> Progress Report</a></li>
				<li class="nav-item"><a class="nav-link" href="FindInterimReport" >Interim Report</a></li>
				<li class="nav-item"><a class="nav-link" href="FindDissertation">Dissertation</a></li>
				<li class="nav-item"><a class="nav-link" href=""
					onclick="loadMedical(); return false;"> Medical</a></li>
 -->
			</ul>
		</nav>
	</div>
</div>

	
<!-- <li class="nav-item"> <a class="dropdown-toggle"
data-toggle="dropdown" href="">Client Details <span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="" onclick="addClient(); return false;"> add
								Client</a></li>
						<li><a href="" id="viewSupervisor"> Edit/View Client
								Certifiate</a></li>
						<li><a href=""> view Client Details </a> </li>

					</ul></li> -->
