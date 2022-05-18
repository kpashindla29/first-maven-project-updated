package com.ab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ab.daos.StudentDAO;
import com.ab.daos.StudentDAOImpl;
import com.ab.models.Student;
import com.ab.services.StudentService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		StudentDAO dao = new StudentDAOImpl();
		
		
		StudentService service = new StudentService(dao);
		
		
		StudentController ctrl = new StudentController(service);
		
		// Write code to read user's input 
		
		
		String firstName = request.getParameter("firstname");
		
		String lastName = request.getParameter("lastname");
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		
		int i = ctrl.registerStudent(new Student(firstName,lastName,username,password));
		
		if(i > 0) {
			
			response.sendRedirect("login.jsp");
		}
		else {
			
			response.sendRedirect("register.jsp");
		}
		
		
	}

}
