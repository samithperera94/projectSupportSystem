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

import com.projectsupport.models.ProjectProposal;
import com.projectsupport.models.User;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.ProjectProposalServices;

/**
 * Servlet implementation class DoAddProjectProposal
 */
@WebServlet("/DoAddProjectProposal")
public class DoAddProjectProposal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAddProjectProposal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		User currentUser = MyUtils.getLoginedUser(session);
		if(currentUser == null){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		int studentId = Integer.parseInt(currentUser.getUserName());
		String projectTitle =  request.getParameter("projectTitle");
		int noOfAttempts =  Integer.parseInt(request.getParameter("noOfAttempts"));
		String previousDecision = request.getParameter("previousDecision");
		String earlierTitle = request.getParameter("earlierTitle");
		String motivation = request.getParameter("motivation");
		String objectives = request.getParameter("objectives");
		String scope = request.getParameter("scope");
		String funtionalities =  request.getParameter("funtionalities");
		String deliverables = request.getParameter("deliverables");
		String resources = request.getParameter("resources");
		String evaluation = request.getParameter("evauation");
		
		ProjectProposal proposal = new ProjectProposal();
		proposal.setProjectTitle(projectTitle);
		proposal.setNoOfAttempts(noOfAttempts);
		proposal.setPreviousDecision(previousDecision);
		proposal.setEarlierProjectTitle(earlierTitle);
		proposal.setMotivation(motivation);
		proposal.setObjectives(objectives);
		proposal.setScope(scope);
		proposal.setFunctionalities(funtionalities);
		proposal.setDeliverables(deliverables);
		proposal.setResources(resources);
		proposal.setEvaluation(evaluation);
		proposal.setStudentId(studentId);
		

		String errorString = null;
		if(errorString == null){
			try {
				ProjectProposalServices.insertProjectProposal(conn, proposal);
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
				
			}
			
		}
		request.setAttribute("errorString", errorString);
	    request.setAttribute("proposal", proposal);
	    if (errorString != null) {
	    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/AddProjectProposal?success=0");
	        dispatcher.forward(request, response);
	       }
	    else {
	    		//out.println("<script>  alert('Student inserted Sucessfully');  </script>");
	           response.sendRedirect(request.getContextPath() + "/EditProjectProposal?success=1");
	           
	    	}
	}

}
