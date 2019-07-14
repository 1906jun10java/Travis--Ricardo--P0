package com.revature.p0.beans;

public class Customer extends User {

	// Constructors
	
	public Customer() {
	}
	
	public Customer(int userID, String firstName, String lastName, String userName, String password) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.loginInfo.put(userName, password);
		//this.fullName = firstName + " " + lastName;
	}
	
	// Instance Variables
		
	//public String fullName;
	
	// Getters & Setters
}
