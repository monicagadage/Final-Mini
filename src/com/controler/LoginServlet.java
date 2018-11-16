
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
import javax.servlet.http.HttpSession;

import com.duo.ResgistrationJdbc;
import com.model.Login;
import com.model.Registration;

/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login l = new Login();
		Registration r = new Registration(l);
		r.setUsername(username);
		r.setPassword(password);
		
		
		System.out.println(r.getUsername());
		
	
		
		List<Registration> lst = new ArrayList<Registration>();
		lst.add(r);
		
		ResgistrationJdbc rj = new ResgistrationJdbc();
		Boolean b = rj.validateData(lst);
		
		if(b==true) {
			HttpSession session = request.getSession(true); // reuse existing
			// session if exist
			// or create one
			session.setAttribute("user", r.getUsername());
			response.sendRedirect("home1.jsp");
			
		}
		else {
			request.setAttribute("message", "Invalid login details -- Please retry");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("LoginErrorServlet");
			dispatcher1.forward(request, response);
		}
		
	}
	}


