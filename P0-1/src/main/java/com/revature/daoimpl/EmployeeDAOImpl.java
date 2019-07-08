package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.utilities.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private boolean result;
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createEmployee(String firstName, String lastName, String userName, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEES VALUES(EMPSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);
		ps.executeUpdate();
	}
	
	public List<Employee> getEmployeeList() throws SQLException{
		// Statement compiled on SQL side generally unsafe due to SQL injection

		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			employeeList.add(e);
		}
		
		return employeeList;
		
	} 
	
	public boolean isEmployee(String username, String password) throws SQLException{
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE USERNAME = "+"'"+username+"' AND PASSWORD = "+"'"+password+"'" );
		Employee e = null;
		while(rs.next()) {
			
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			if(e.getUserName().equals(username) && e.getPassword().equals(password)) {
				result = true;
			}else {
				result = false;
			}
	
		}
		return result;
		
		
	}
	
	

}
