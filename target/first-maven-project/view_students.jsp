<%@page import="com.ab.models.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> List of Students </title>
</head>
<body>

 <%
    
  List<Student> students = (List<Student>)session.getAttribute("studentList");
 
 %>
 
 <h1> List of Registered Students are : </h1>
 
 <%=students %>
 

</body>
</html>