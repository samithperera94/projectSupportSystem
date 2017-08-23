package com.projectsupport.controls;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectsupport.models.Student;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.StudentServices;

/**
 * Servlet implementation class DoInsertStudent
 */
@WebServlet("/DoInsertStudent")
public class DoInsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoInsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String mobileNo = request.getParameter("mobileNo");
		String strDob = request.getParameter("dob");		
		String gender = request.getParameter("gender");
		
		 
		Student newStudent = new Student();
		newStudent.setStudentId(studentId);
		newStudent.setFirstName(firstName);
		newStudent.setLastName(lastName);
		newStudent.setNIC(nic);
		newStudent.setEmail(email);
		newStudent.setAddress(address);
		newStudent.setMobileNo(mobileNo);
		newStudent.setDob(strDob);
		newStudent.setGender(gender);
		 
		
		String errorString = null;
		if(errorString == null){
			try {
				StudentServices.insertStudent(conn, newStudent);
				
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
				
			}
			
		}
		
		request.setAttribute("errorString", errorString);
	    request.setAttribute("newStudent", newStudent);
	    //PrintWriter out = response.getWriter();
	    if (errorString != null) {
	    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/edccoordinator.jsp");
	        dispatcher.forward(request, response);
	       }
	    else {
	    		//out.println("<script>  alert('Student inserted Sucessfully');  </script>");
	           response.sendRedirect(request.getContextPath() + "/edccoordinator.jsp");
	           
	    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






