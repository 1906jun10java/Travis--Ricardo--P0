package com.revature.p0.beans;

public class Customer /*extends User*/ {
	
	private String firstName;
	private String lastName;
	private final String classification = "Customer";
	private String userName;
	private String password;
	
	public Customer() {					// no argument constructor
		super();
	}	
	
	public Customer(String firstName, String lastName, String classification, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
	//	this.classification = classification;  // this is a final field and cannot be assigned.
		this.password = password;
		this.userName = userName;
	}
	
	
	// Getters and Setters
	
	public String getFirstName() {					// firstName getter
		return firstName;
	}

	public void setFirstName(String firstName) {	// firstName setter
		this.firstName = firstName;
	}

	public String getLastName() {					// lastName getter
		return lastName;
	}

	public void setLastName(String lastName) {		// lastName setter
		this.lastName = lastName;
	}					
	public String getClassification() {				// classification getter
		return classification;
	}																
	/*	public void setClassification(String classification) {		
		this.classification = classification;						//classification should not be able to change
	}															*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {		// password setter
		this.password = password;
	}
	public String getUserName() {					// userName getter
		return userName;
	}
	public void setUserName(String userName) {		// userName setter
		this.userName = userName;
	}
	
/*	void seeCars() {
		System.out.print("List of cars on Lot " + carList.toString());
	}
*/	

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", classification=" + classification
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	/*void placeBid(Cars car, double money) {
		System.out.println("Placing a bid of: " + money + " for :" + car);
	
	}
	
	*/
	
	
	
	

}
