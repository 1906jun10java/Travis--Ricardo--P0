package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public abstract void createEmployee(String firstName, String lastName, String userName, String password) 
			throws SQLException;
	
	public abstract List<Employee> getEmployeeList()
			throws SQLException;
	
	public abstract boolean isEmployee(String username, String password)
			throws SQLException;
	

}
