package com.revature.beans;

public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	public Customer() {
		super();
	}
	
	public Customer(int customerID, String firstName, String lastName, String userName, String password) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	

}
