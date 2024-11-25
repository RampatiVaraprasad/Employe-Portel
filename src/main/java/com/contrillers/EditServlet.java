package com.contrillers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.Employedao;
import com.dto.Employees;

// id will be disabled or enabled in this page --- if you are disabled the id will get Number formate exception :null 
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		
		Employedao ed = new Employedao();
		try {
			Employees emp = ed.getEmploye(id1);
			out.print("<html>");
			out.print("<body bgcolor = 'lightblue'>");
			out.print("<h1> Edit Employe Details </h1>");
			out.print("<form action = 'EditServlet2' method = 'post'>");
			out.print("<table border = 1px>");
			out.print("<tr>"
							+ "<td>ID</td>"
							+ "<td><input type = 'text' name = 'id' value = "+emp.getId()+" ></td>"    
							+"</tr>"
							+"<tr>"
							+ "<td>Firstname</td>"
							+ "<td><input type = 'text' name = 'firstname' value = "+emp.getFirstname()+"></td>"
							+"</tr>"
							+"<tr>"
							+ "<td>Lastname</td>"
						    + "<td><input type = 'text' name = 'lastname' value = "+emp.getLastname()+"></td>"
							+"</tr>"
							+"<tr>"
							+ "<td>Username</td>"
							+ "<td><input type = 'text' name = 'username' value = "+emp.getUsername()+"></td>"
							+"</tr>"
							+"<tr>"
							+ "<td>Password</td>"
							+ "<td><input type = 'text' name = 'password' value = "+emp.getPassword()+"></td>"
							+"</tr>"
							+"<tr>"
							+ "<td>Mobile</td>"
							+ "<td><input type = 'text' name = 'mobile' value = "+emp.getMobile()+"></td>"
							+"</tr>"
							+"<tr>"
							+ "<td>Age</td>"
						    + "<td><input type = 'text' name = 'age' value = "+emp.getAge()+"></td>"
						    +"</tr>"
							+"<tr>"
							+ "<td>City</td>"
							+ "<td><input type = 'text' name = 'city' value = "+emp.getCity()+"></td>"
							+"</tr>"
							+"<tr>"
						    + "<td>Country</td>"
							+ "<td><input type = 'text' name = 'country' value = "+emp.getCountry()+"></td>"
							+"</tr>"
							+"<tr>"	
							+ "<td>Gender</td>"
							+ "<td><input type = 'text' name = 'gender' value = "+emp.getGender()+"></td>"
							+ "</tr>");
			out.print("<input type = 'submit' value = 'Edit & Submit'>");
			out.print("</table>");
			out.print("/form");
			out.print("</body>");
			out.print("</html>");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
