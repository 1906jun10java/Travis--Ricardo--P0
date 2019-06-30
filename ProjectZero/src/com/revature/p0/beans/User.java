package com.revature.p0.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class User {

	// Constructors
	
	public User() {
	}
	
	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginInfo.put(userName, password);
		//this.fullName = firstName + " " + lastName;
	}
	
	// Instance Variables
			
	protected String firstName;
	protected String lastName;
	protected Map<String, String> loginInfo = new HashMap<String, String>();
	
	//public String fullName = this.firstName + " " + getLastName();
	//public String fullName;
	
	// carsOwned maybe should be a Map with Car: Monthly Payment
	public ArrayList<Car> carsOwned = new ArrayList<Car>();
	public ArrayList<Offer> offersMade = new ArrayList<Offer>();
	
	
	// Getters & Setters
	
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
	//public String getFullName() {
		//return fullName;
	//}
	//public void setFullName(String fullName) {
		//this.fullName = fullName;
	//}
	public ArrayList<Car> getCarsOwned() {
		return carsOwned;
	}
	public void setCarsOwned(ArrayList<Car> carsOwned) {
		this.carsOwned = carsOwned;
	}
	public ArrayList<Offer> getOffersMade() {
		return offersMade;
	}
	public void setOffersMade(ArrayList<Offer> offersMade) {
		this.offersMade = offersMade;
	}
	public Map<String, String> getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(Map<String, String> loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	// toString
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	/*
	// toString
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", loginInfo="
				+ loginInfo + ", carsOwned=" + carsOwned + ", offersMade=" + offersMade + "]";
	}
	*/
	
}
