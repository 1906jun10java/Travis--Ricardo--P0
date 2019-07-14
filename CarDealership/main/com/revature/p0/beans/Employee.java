package com.revature.p0.beans;

public class Employee extends User {

	// Constructors
	
	public Employee() {
	}
	
	public Employee(int userID, String firstName, String lastName, String userName, String password) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.loginInfo.put(userName, password);
	}
	
	// Instance Variables
			
		
		
	// Getters & Setters
}
