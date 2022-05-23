package com.ab.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ab.models.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private Connection con;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public StudentDAOImpl() {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/test","root",""); 
		
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e);
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			
		}
		
	}
	
	@Override
	public int register(Student s) {
		
		try {
			
			
			this.pst = this.con.prepareStatement("INSERT into student(firstname,lastname,username, password) VALUES(?,?,?,?)");
			
			this.pst.setString(1, s.getFirstName());
			this.pst.setString(2, s.getLastName());
			this.pst.setString(3, s.getUsername());
			this.pst.setString(4, s.getPassword());
			
			int i = this.pst.executeUpdate();
			
			return i;
			
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			return -1;
			
		}
		
		
	}

	@Override
	public Student login(String username, String password) {
		
		
		try {
			
		  this.pst = this.con.prepareStatement("SELECT * from student WHERE username = ? and password = ? " );
		  
		  
		  this.pst.setString(1, username);
		  this.pst.setString(2, password);
		  
		  
		  this.rs = this.pst.executeQuery();
		  
		  
		  if(rs.next()) {
			  Student s = new Student(rs.getInt("student_id"),
					  					rs.getString(2),
					  					rs.getString(3),
					  					rs.getString(4),
					  					rs.getString(5)
					  				  );
			  
			  return s;
		  }
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			return null;
		}
		
		return null;
		
	}



	@Override
	public List<Student> loadRegisteredStudents() {
		
		List<Student> students = new ArrayList<>();
		
		try {
			
			this.pst = this.con.prepareStatement("SELECT * from student");
			
			this.rs = this.pst.executeQuery();
			
			while(this.rs.next()) {
				
				Student s = new Student(this.rs.getInt("student_id"),
										this.rs.getString("firstname"),
										this.rs.getString("lastname"),
										this.rs.getString("username"),
										this.rs.getString("password")
										);
				
				
			    students.add(s);
			}
			
			
		}
		catch(SQLException e) {
			
			System.out.println(e);
			return null;
			
		}
		
		
		return students;
	}
	
	
	
	

}
