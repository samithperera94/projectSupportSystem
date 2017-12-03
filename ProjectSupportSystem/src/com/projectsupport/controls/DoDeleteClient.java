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

import com.projectsupport.models.User;
import com.projectsupport.services.ClientServices;
import com.projectsupport.services.MyUtils;


/**
 * Servlet implementation class DoDeleteClient
 */
@WebServlet("/DoDeleteClient")
public class DoDeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoDeleteClient() {
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
		if(currentUser == null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login");
	        dispatcher.forward(request, response);
	        return;
		}
		int studentId = Integer.parseInt(currentUser.getUserName());
		String errorString = null;
        
		if(errorString == null){
			try {
				System.out.println("Inside try block");
				ClientServices.deleteClient(conn, studentId);
			} catch (SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
			}
			response.sendRedirect(request.getContextPath() + "/AddClient?success=1");
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
