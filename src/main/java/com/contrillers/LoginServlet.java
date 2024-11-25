package com.contrillers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.Employedao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();

		String username = request.getParameter("uname");
		String password =  request.getParameter("pass");

		Employedao ed = new Employedao();
		try {
			boolean status = ed.validateUserCredentials(username, password);
			if(status) {
				out.println("<html>");
				out.println("<body bgcolor = 'lightgreen'>");
				out.println("<p> Welcom to employe portel</p>" + username );
				out.println("</body>");
				out.println("<a href = 'view'> show employe details </a>");
				out.println("</html>");

			}else {
				out.println("<html><body bgcolor = 'red'><b>something went wrong </b></body></html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

}
