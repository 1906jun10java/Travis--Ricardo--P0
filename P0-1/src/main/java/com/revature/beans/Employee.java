package com.revature.beans;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeID, String firstName, String lastName, String userName, String password) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	

	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\n"+"Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	

}
