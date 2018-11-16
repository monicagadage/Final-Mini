package com.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginErrorServlet
 */
@WebServlet("/LoginErrorServlet")
public class LoginErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			String message = (String) request.getAttribute("message");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3  align='right' >"+message+"</h3>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Signup.jsp");
		dispatcher.include(request, response);
	}
		catch(Exception e) {
			request.setAttribute("Exception", e);
			RequestDispatcher error = request.getRequestDispatcher("error.jsp");
			error.include(request, response);
		}

}
}
