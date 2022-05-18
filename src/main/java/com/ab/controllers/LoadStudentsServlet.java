package com.ab.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ab.daos.StudentDAO;
import com.ab.daos.StudentDAOImpl;
import com.ab.models.Student;
import com.ab.services.StudentService;

/**
 * Servlet implementation class LoadStudentsServlet
 */
@WebServlet("/LoadStudentsServlet")
public class LoadStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadStudentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao = new StudentDAOImpl();
		
		
		StudentService service = new StudentService(dao);
		
		
		StudentController ctrl = new StudentController(service);
		
		
		List<Student> students = ctrl.getAllStudents();
		
		// This below statement enables session
		HttpSession session = request.getSession(true);
		
		// Code to store list of students in a session object
		
		session.setAttribute("studentList", students);
		
		// Redirect the client request to view_students.jsp
		response.sendRedirect("view_students.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
