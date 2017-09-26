	package com.projectsupport.controls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectsupport.models.Student;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.StudentServices;

/**
 * Servlet implementation class ShowStudentSubmissions
 */
@WebServlet("/ShowStudentSubmissions")
public class ShowStudentSubmissions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudentSubmissions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("stuID");
		int id = Integer.parseInt(studentId);
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		session.setAttribute("studentID", studentId);
		Student student = null;
		try {
			student = StudentServices.findStudent(conn, id);
			System.out.println(student.getFullName());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		session.setAttribute("student", student);
		RequestDispatcher dispather = this.getServletContext()
				.getRequestDispatcher("/projectcoordinator/onestudentsubmissions.jsp");
		dispather.forward(request, response);
		System.out.println("add client servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
