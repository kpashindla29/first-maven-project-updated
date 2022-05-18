package com.ab.services;

import java.util.List;

import com.ab.daos.StudentDAO;
import com.ab.models.Student;

public class StudentService {
	
	private StudentDAO studentDAO;
	
	// Code to write DI using constructor 
	
	public StudentService(StudentDAO studentDAO) {
		
		this.studentDAO = studentDAO;
	}
	
	
	// Write some business methods
	
	public int registerStudent(Student s) {
		
		// As part of registration you may consider writing some code to encrypt user password
		return this.studentDAO.register(s);
		
	}
	
	
	public Student studentLogin(String username, String password) {
		
		
		return this.studentDAO.login(username, password);
		
	}
	
	
	public List<Student> findAllStudents(){
	
		return this.studentDAO.loadRegisteredStudents();
	
	}
	

}
