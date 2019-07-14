package com.revature.p0.beans;

import java.util.ArrayList;

public class Car {

	// Constructors
	
	public Car() {
	}
	
	public Car(int carID, int yearManufactured, String make, String model, double askingPrice, double monthlyPayment, int customerID) {
		this.carID = carID;
		this.yearManufactured = yearManufactured;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.monthlyPayment = monthlyPayment;
		this.customerID = customerID;
	}
	
	// Instance Variables
	
	private int carID;
	private int yearManufactured;
	private String make;
	private String model;
	private double askingPrice;
	private double amountStillOwed;
	private double monthlyPayment;
	private int customerID;
	private User owner;
	
	public ArrayList<Offer> offersMadeForCar = new ArrayList<Offer>();
	
	// Getters & Setters
	
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
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
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		return "Car ID: " + carID + " - " + yearManufactured + " " + make + " " + model;
	}
	
	/*
	@Override
	public String toString() {
		return "Car [yearManufactured=" + yearManufactured + ", make=" + make + ", model=" + model + ", askingPrice="
				+ askingPrice + ", amountStillOwed=" + amountStillOwed + ", owner=" + owner + ", offersMadeForCar="
				+ offersMadeForCar + "]";
	}
	*/
	
	
}
