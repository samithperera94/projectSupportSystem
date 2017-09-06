package com.projectsupport.controls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.projectsupport.models.ProjectProposal;
import com.projectsupport.models.User;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.ProjectProposalServices;

/**
 * Servlet implementation class DoViewProjectProposal
 */
@WebServlet("/DoViewProjectProposal")
public class DoViewProjectProposal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoViewProjectProposal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		User currentUser = MyUtils.getLoginedUser(session);
		int studentId = Integer.parseInt(currentUser.getUserName());
		String errorString = null;
		ProjectProposal proposal = new ProjectProposal();
		try {
			proposal = ProjectProposalServices.findProjectProposal(conn, studentId);
		} catch (SQLException e){
			e.printStackTrace();
			errorString = e.getMessage();
		}
		String json = new Gson().toJson(proposal);
		request.setAttribute("errorString", errorString);
		request.setAttribute("projectProposalDetails", proposal);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
