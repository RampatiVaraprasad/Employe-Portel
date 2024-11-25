package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Employees;

public class Employedao {

	/**
	 * creating a dabase connection to mysql DB
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		// loading the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// create the connection object
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employe", "root", "root");
		return con;

	}

	/**
	 *  Inserting a employe info to database table
	 * @param emp
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean createEmployeAccount(Employees emp) throws ClassNotFoundException, SQLException {
		boolean status = false;

		Connection con = 	getConnection();
		String sql = "insert into  employee values(?,?,?,?,?,?,?,?,?,?)";
		// create the prepared statements object
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setInt(1, emp.getId());
		prstmt.setString(2, emp.getFirstname());
		prstmt.setString(3, emp.getLastname());
		prstmt.setString(4, emp.getUsername());
		prstmt.setString(5, emp.getPassword());
		prstmt.setLong(6, emp.getMobile());
		prstmt.setInt(7, emp.getAge());
		prstmt.setString(8, emp.getCity());
		prstmt.setString(9, emp.getCountry());
		prstmt.setString(10, emp.getGender());

		int i = prstmt.executeUpdate();
		if(i>0) {
			status = true;
		}
		return status;
	}

	/**
	 * validate user credentials
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean validateUserCredentials(String username, String password) throws ClassNotFoundException, SQLException {
		boolean status = false;
		Connection con = getConnection();
		String sql = "select * from employee where username = ? and password = ? ";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, username);
		prstmt.setString(2, password);
		//	status = prstmt.execute();	
		ResultSet rs = prstmt.executeQuery();	
		if(rs.next()) {
			status = true;
		}
		return status;

	}
	
	public List <Employees>getEmployeDetails() throws ClassNotFoundException, SQLException{
		List <Employees> empDetails = new ArrayList<Employees>();
		Connection con = getConnection();
		String sql = "select * from employee";
		PreparedStatement prstmt = con.prepareStatement(sql);
		ResultSet rs = prstmt.executeQuery();
		while(rs.next()) {
			Employees emp = new Employees();
			emp.setId(rs.getInt(1));
			emp.setFirstname(rs.getString(2));
			emp.setLastname(rs.getString(3));
			emp.setUsername(rs.getString(4));
			emp.setPassword(rs.getString(5));
			emp.setMobile(rs.getLong(6));
			emp.setAge(rs.getInt(7));
			emp.setCity(rs.getString(8));
			emp.setCountry(rs.getString(9));
			emp.setGender(rs.getString(10));
			empDetails.add(emp);
		}
		return empDetails;

	}

	public Employees getEmploye(int id1) throws ClassNotFoundException, SQLException {
		Employees emp = new Employees();
		Connection con = getConnection();
		String sql = "select * from employee where id = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setInt(1, id1);
		ResultSet rs = prstmt.executeQuery();
		while(rs.next()) {
			emp.setId(rs.getInt(1));
			emp.setFirstname(rs.getString(2));
			emp.setLastname(rs.getString(3));
			emp.setUsername(rs.getString(4));
			emp.setPassword(rs.getString(5));
			emp.setMobile(rs.getLong(6));
			emp.setAge(rs.getInt(7));
			emp.setCity(rs.getString(8));
			emp.setCountry(rs.getString(9));
			emp.setGender(rs.getString(10));
		}
		return emp;
	}

	public Boolean updateEmploye(Employees emp) throws ClassNotFoundException, SQLException {
		Boolean status = false;
		Connection con = getConnection();
		String sql = "update employee set firstname = ?, lastname = ?, username = ?, password = ?,  mobile= ?, age = ?, city = ?, country = ?, gender = ? where id = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, emp.getFirstname());
		prstmt.setString(2, emp.getLastname());
		prstmt.setString(3, emp.getUsername());
		prstmt.setString(4, emp.getPassword());
		prstmt.setLong(5, emp.getMobile());
		prstmt.setInt(6, emp.getAge());
		prstmt.setString(7, emp.getCity());
		prstmt.setString(8, emp.getCountry());
		prstmt.setString(9, emp.getGender());
		prstmt.setInt(10, emp.getId());

		 int i = prstmt.executeUpdate();
		 if(i>0) {
			 status = true;
		 }
		return status;
	}

	public boolean deleteEmployeById(int id1) throws ClassNotFoundException, SQLException {
		boolean status = false;
		Connection con = getConnection();
		String sql = "delete from employee where id = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setInt(1, id1);
		int i = prstmt.executeUpdate();
		if(i>0) {
			status = true;
		}
		return status;
	}
}
 
