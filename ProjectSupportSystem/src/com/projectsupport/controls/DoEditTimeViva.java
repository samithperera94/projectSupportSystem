package com.projectsupport.controls;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectsupport.models.Viva;
import com.projectsupport.models.User;
import com.projectsupport.services.VivaServices;
import com.projectsupport.services.MyUtils;


/**
 * Servlet implementation class DoEditTimeViva
 */
@WebServlet("/DoEditTimeViva")
public class DoEditTimeViva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEditTimeViva() {
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
		
		//check if there is or isn't a logged user and if not, direct to login view
		if(currentUser == null){
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login");
	        dispatcher.forward(request, response);
	        return;
		}
		
		//get entered values
		int id = Integer.parseInt(currentUser.getUserName());
		//int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String select[] = request.getParameterValues("time");
		
		try{
			//create a new viva object
			Viva newviva = new Viva();
			newviva.setId(id); 
			newviva.setName(name);
			newviva.setTime(select);
			
			String errorString = null;
			if(errorString == null){
				try{//call to the editTime method in VivaServices
					VivaServices.editTime(conn, newviva);
				}
				catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					errorString = e.getMessage();
				}
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("newviva", newviva);
			
			if(errorString != null){
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/EditTimeViva?success=0");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect(request.getContextPath() + "/EditTimeViva?success=0");
			}
		}
	
		catch (FileNotFoundException e) {
			// TODO: handle exception
			
		}
		
	}

	}
	
