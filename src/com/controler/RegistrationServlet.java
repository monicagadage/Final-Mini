package com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duo.ResgistrationJdbc;
import com.model.Login;
import com.model.Registration;

/**
 * Servlet implementation class registrationservlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("S1");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		
		long phoneno = Long.parseLong(request.getParameter("phone"));
		String password = request.getParameter("password");
		int Balance = Integer.parseInt(request.getParameter("Balance"));
		
		Login l = new Login();
		Registration r = new Registration(l);
		
		r.setEmail(email);
		r.setUsername(username);
		r.setPassword(password);
		r.setPhoneNO(phoneno);
		r.setCost(Balance);
		List<Registration> lst = new ArrayList<Registration>();
		lst.add(r);
		
		ResgistrationJdbc rj = new ResgistrationJdbc();
		int i = rj.saveData(lst);
		if(i>0) {
			
			out.write("<script language='javascript'>window.alert('You have successfully registered yourself -- Login to continue');window.location='home1.jsp';</script>");
			
			/*response.sendRedirect("Login.jsp");*/
			
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
			request.setAttribute("user", username);
			request.setAttribute("message", "You have successfully registered yourself and we have made you login here..." );
			dispatcher.forward(request, response);*/
		}
		else {
			
			request.setAttribute("message", "Data not inserted for some reason -- Please try again");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("RegistrationErrorServlet");
			dispatcher1.forward(request, response);
		}

	}



	}


