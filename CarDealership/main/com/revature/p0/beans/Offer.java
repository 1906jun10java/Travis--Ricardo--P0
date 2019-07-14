package com.revature.p0.beans;

public class Offer {

	// Constructors
	
	public Offer(int customerID, int carID, double amountWillingToPay) {
		this.customerID = customerID;
		this.carID = carID;
		this.amountWillingToPay = amountWillingToPay;
	}
	
	public Offer(Customer customerMakingOffer, Car carDesired, double amountWillingToPay) {
		this.customerMakingOffer = customerMakingOffer;
		this.carDesired = carDesired;
		this.amountWillingToPay = amountWillingToPay;
	}
	
	// Instance Variables
	
	private Customer customerMakingOffer;
	private int customerID;
	private int carID;
	private Car carDesired = new Car();
	private double amountWillingToPay;
	
	// Getters & Setters
	
	public Car getCarDesired() {
		return carDesired;
	}
	public void setCarDesired(Car carDesired) {
		this.carDesired = carDesired;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public double getAmountWillingToPay() {
		return amountWillingToPay;
	}
	public void setAmountWillingToPay(double amountWillingToPay) {
		this.amountWillingToPay = amountWillingToPay;
	}
	public Customer getCustomerMakingOffer() {
		return customerMakingOffer;
	}
	public void setCustomerMakingOffer(Customer customerMakingOffer) {
		this.customerMakingOffer = customerMakingOffer;
	}
	public int getCustomerID () {
		return this.customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	// toString method
	
	@Override
	public String toString() {
		return customerMakingOffer.getFirstName() + " " + customerMakingOffer.getLastName() + 
				" : offer of $" + amountWillingToPay + " for the " +
				carDesired.getYearManufactured() + " " + carDesired.getMake()  + " "
				+ carDesired.getModel();
	}	
	
	/*
	 * @Override
	public String toString() {
		return "Offer [carDesired=" + carDesired.getYearManufactured() + " " + carDesired.getMake()  + " "
				+ carDesired.getModel()
				+ ", amountWillingToPay=" + amountWillingToPay
				+ ", customerMakingOffer=" + customerMakingOffer.getFirstName() + " " + customerMakingOffer.getLastName()
				+ "]";
	}	
	 */
	
}
