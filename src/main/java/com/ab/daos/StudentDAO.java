package com.ab.daos;

import java.util.List;

import com.ab.models.Student;

public interface StudentDAO {
	
	public int register(Student s);
	public Student login(String username,String password);
	public List<Student> loadRegisteredStudents(); 

}
