package com.revature.p0.beans;

public class Offer {

	// Constructors
	
	public Offer(Customer customerMakingOffer, Car carDesired, double amountWillingToPay) {
		this.customerMakingOffer = customerMakingOffer;
		this.carDesired = carDesired;
		this.amountWillingToPay = amountWillingToPay;
	}
	
	// Instance Variables
			
	private Car carDesired = new Car();
	private double amountWillingToPay;
	private Customer customerMakingOffer;
	
	// Getters & Setters
	
	public Car getCarDesired() {
		return carDesired;
	}
	public void setCarDesired(Car carDesired) {
		this.carDesired = carDesired;
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
