package p0.beans;

import p0.beans.User;

public class Employee extends User {

	// Constructors
	
	public Employee() {	
	}
	
	public Employee(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginInfo.put(userName, password);
	}
	
	// Instance Variables
			
		
		
	// Getters & Setters
}