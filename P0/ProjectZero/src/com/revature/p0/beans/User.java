package com.revature.p0.beans;

public abstract class User {
	
	String firstName;
	String lastName;
	String classification = " ";
	
	
	abstract void login();
	abstract void register();
	abstract void viewCars();
	

}
