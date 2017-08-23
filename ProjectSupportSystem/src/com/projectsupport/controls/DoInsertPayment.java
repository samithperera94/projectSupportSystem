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

import com.projectsupport.models.Payment;
import com.projectsupport.services.MyUtils;
import com.projectsupport.services.PaymentServices;
import com.projectsupport.services.StudentServices;

/**
 * Servlet implementation class DoInsertPayment
 */
@WebServlet("/DoInsertPayment")
public class DoInsertPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoInsertPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(request);
		int paymentId = Integer.parseInt(request.getParameter("paymentId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String paidDate = request.getParameter("paidDate");
		int studentId = 15000753;
		
		
		Payment payment = new Payment();
		payment.setPaymentId(paymentId);
		payment.setAmount(amount);
		payment.setPaidDate(paidDate);
		payment.setStudentId(studentId);
		String errorString = null;
		if(errorString == null){
			try {
				PaymentServices.insertPayment(conn, payment);
				
			} catch(SQLException e){
				e.printStackTrace();
				errorString = e.getMessage();
				
			}
			
		}
		
		request.setAttribute("errorString", errorString);
	    request.setAttribute("payment", payment);
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
		
	}

}
