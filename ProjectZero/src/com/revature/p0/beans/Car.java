package com.revature.p0.beans;

import java.util.ArrayList;

public class Car {

	// Constructors
	
	public Car() {
	}
	
	public Car(int yearManufactured, String make, String model, double askingPrice) {
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.amountStillOwed = askingPrice;
	}
	
	// Instance Variables
	
	private int yearManufactured;
	private String make;
	private String model;
	private String nameOfCar = yearManufactured + " " + make + " " + model;
	private double askingPrice;
	//private double amountPaidForCar;
	private double amountStillOwed;
	private double monthlyPayment;
	private User owner;
	
	public ArrayList<Offer> offersMadeForCar = new ArrayList<Offer>();
	
	// Getters & Setters
	
	public int getYearManufactured() {
		return yearManufactured;
	}
	
	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNameOfCar() {
		return nameOfCar;
	}
	public double getAskingPrice() {
		return askingPrice;
	}
	public void setAskingPrice(double askingPrice) {
		this.askingPrice = askingPrice;
	}
	public double getAmountStillOwed() {
		return amountStillOwed;
	}
	public void setAmountStillOwed(double amountStillOwed) {
		this.amountStillOwed = amountStillOwed;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public ArrayList<Offer> getOffersMadeForCar() {
		return offersMadeForCar;
	}
	public void setOffersMadeForCar(ArrayList<Offer> offersMadeForCar) {
		this.offersMadeForCar = offersMadeForCar;
	}
	
	// methods
	
	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model + ", askingPrice="
				+ askingPrice + ", amountStillOwed=" + amountStillOwed + ", owner=" + owner + ", offersMadeForCar="
				+ offersMadeForCar + "]";
	}
	
	
}
