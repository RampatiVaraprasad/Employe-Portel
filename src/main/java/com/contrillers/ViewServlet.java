package com.contrillers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.dao.Employedao;
import com.dto.Employees;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Employedao ed = new Employedao();

		try {
			List<Employees> empDetails = ed.getEmployeDetails();
			out.print("<html>");
			out.print("<body bgcolor = 'lightblue'>");
			out.print("<h1> Employe Details </h1>");
			out.print("<table border = '1px'>");
			out.print(
					"<th>ID</th><th>Firstname</th><th>Lastname</th><th>Username</th><th>Password</th><th>Mobile</th><th>Age</th><th>City</th><th>Country</th><th>Gender</th><th>Edit</th><th>Delete</th>");
			for (Employees emp : empDetails) {
				out.print("<tr>"
			+ " <td>" + emp.getId() + "</td>" 
			+ " <td>" + emp.getFirstname() + "</td>" 
			+ " <td>" + emp.getLastname() + "</td>" 
			+ " <td>" + emp.getUsername() + "</td>" 
			+ " <td>" + emp.getPassword() + "</td>"
			+ " <td>" + emp.getMobile() + "</td>" 
			+ " <td>" + emp.getAge() + "</td>" 
			+ " <td>" + emp.getCity() + "</td>" 
			+ " <td>" + emp.getCountry() + "</td>"
			+ " <td>" + emp.getGender() + "</td>"
			+ " <td>" + "<a href = 'EditServlet?id="+emp.getId() +"'>Edit</td>" 
			+ " <td>" + "<a href = 'DeleteServlet?id="+ emp.getId() +"'>Delete</td>" + " </tr>");
			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

}
