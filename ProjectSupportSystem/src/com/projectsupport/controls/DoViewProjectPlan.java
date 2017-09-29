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

import com.google.gson.Gson;
import com.projectsupport.models.ProjectPlan;
import com.projectsupport.models.User;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.ProjectPlanServices;


/**
 * Servlet implementation class DoViewProjectPlan
 */
@WebServlet("/DoViewProjectPlan")
public class DoViewProjectPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoViewProjectPlan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		int studentId;
		User currentUser = MyUtils.getLoginedUser(session);
		if(currentUser == null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login");
	        dispatcher.forward(request, response);
	        return;
		}
		String user1 = currentUser.getUserName();
		
		System.out.println(user1);
		if(user1.equals("pro01")){
			studentId = Integer.parseInt((String) request.getSession().getAttribute("studentID"));
		}
		else{
			studentId = Integer.parseInt(currentUser.getUserName());
		}
		
		String errorString = null;
		ProjectPlan plan = new ProjectPlan();
		try {
			plan = ProjectPlanServices.findProjectPlan(conn, studentId);	
			System.out.println(plan.getStartingDate1());
			System.out.println(plan.getStartingDate2());
			System.out.println(plan.getStartingDate3());
			System.out.println(plan.getStartingDate4());
			System.out.println(plan.getStartingDate5());
			System.out.println(plan.getStartingDate6());
			System.out.println(plan.getStartingDate7());
			System.out.println(plan.getStartingDate8());
			System.out.println(plan.getStartingDate9());
			System.out.println(plan.getStartingDate10());
		} catch (SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		String json = new Gson().toJson(plan);
		request.setAttribute("errorString", errorString);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
