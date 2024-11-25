package com.contrillers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.Employedao;
import com.dto.Employees;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public EditServlet2() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);   // NumberFormatException: Cannot parse null string
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");

		String mob = request.getParameter("mobile");
		long mobils = Long.parseLong(mob);

		String sage = request.getParameter("age");
		int age1 = Integer.parseInt(sage);

		String citys = request.getParameter("city");
		String countrys = request.getParameter("country");
		String genders = request.getParameter("gender");

		Employees emp = new Employees();
		emp.setId(id1);
		emp.setFirstname(fname);
		emp.setLastname(lname);
		emp.setUsername(uname);
		emp.setPassword(pwd);
		emp.setMobile(mobils);
		emp.setAge(age1);
		emp.setCity(citys);
		emp.setCountry(countrys);
		emp.setGender(genders);

		Employedao ed = new Employedao();
		try {
			Boolean status = ed.updateEmploye(emp);
			if(status) {
				response.sendRedirect("view");
			}else{
				out.println("<body bgcolor = 'lightgreen'>");
				out.println("<h1>sorry unable to proceed</h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

}
