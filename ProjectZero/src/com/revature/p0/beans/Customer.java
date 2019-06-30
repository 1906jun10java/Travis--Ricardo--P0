package com.revature.p0.beans;

public class Customer extends User {

	// Constructors
	
	public Customer() {
	}
	
	public Customer(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginInfo.put(userName, password);
		//this.fullName = firstName + " " + lastName;
	}
	
	// Instance Variables
		
	//public String fullName;
	
	// Getters & Setters
}
