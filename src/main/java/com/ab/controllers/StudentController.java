package com.ab.controllers;

import java.util.List;

import com.ab.models.Student;
import com.ab.services.StudentService;

public class StudentController {
	
	
	private StudentService studentService;
	
	
	// Try to inject/wire subtypes into supertype (Abstract class/Interface)
	// With this you can make your code polymorphic
	public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
		
	}
	
	public int registerStudent(Student s) {
		
		return this.studentService.registerStudent(s);
	}
			
			
	public Student loginStudent(String username,String password) {
		
		return this.studentService.studentLogin(username, password);
	}
	
	public List<Student> getAllStudents(){
		
		return this.studentService.findAllStudents();
	}
	
	
}
