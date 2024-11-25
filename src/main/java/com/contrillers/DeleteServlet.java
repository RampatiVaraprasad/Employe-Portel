package com.contrillers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.dao.Employedao;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public DeleteServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");
		int	id1 = Integer.parseInt(id);

		Employedao ed = new Employedao();
		try {
			boolean status = ed.deleteEmployeById(id1);
			if(status) {
				response.sendRedirect("delete.html");
			}else {
				response.sendRedirect("signup.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}







		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
