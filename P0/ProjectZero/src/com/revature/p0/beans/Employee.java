package com.revature.p0.beans;
import com.revature.p0.beans.Bids;
import com.revature.p0.beans.Cars;


public class Employee /*extends User*/ {
	
	private String firstName;
	private String lastName;
	private final String classification = "Employee";
	private String userName;
	private String password;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, String classification, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
	//	this.classification = classification; // this is a final field and cannot be classified
		this.userName = userName;
		this.password = password;
	}
	
	
	// Getters and Sitters

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

	public String getClassification() {
		return classification;
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
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", classification=" + classification
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	void getBids() {
		System.out.println();
	}
	
	
	
	
	
	
	

}
