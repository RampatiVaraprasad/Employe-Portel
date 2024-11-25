package com.contrillers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;

import com.dao.Employedao;
import com.dto.Employees;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id1 = request.getParameter("id");
		int ids = Integer.parseInt(id1);
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		String mob = request.getParameter("mobile");
		Long mobils = Long.parseLong(mob);
		String sage = request.getParameter("age");
		 int age1 = Integer.parseInt(sage);
		 
		String citys = request.getParameter("city");
		String countrys = request.getParameter("country");
		String genders = request.getParameter("gender");
		
		Employees emp = new Employees();
		emp.setFirstname(fname);
		emp.setLastname(lname);
		emp.setUsername(uname);
		emp.setPassword(pwd);
		emp.setId(ids);
		emp.setAge(age1);
		emp.setMobile(mobils);
		emp.setCity(citys);
		emp.setCountry(countrys);
		emp.setGender(genders);

		Employedao sd = new Employedao();
		try {
			boolean status =  sd.createEmployeAccount(emp);
			if(status) {
			out.println("<html>");
			out.println("<body bgcolor = 'red'>");
			out.println("<b>Account has created successfully </b><br/><br/>");
			out.println("<a href = 'Login2.html'>Login here</a>");
			out.println("</body>");
			out.println("</html>");

			}else {
				out.println("<html><body bgcolor = 'red'><b>something went wrong try agin </b></body></html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}
