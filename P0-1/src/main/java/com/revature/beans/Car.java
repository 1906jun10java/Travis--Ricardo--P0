package com.revature.beans;

public class Car {
	
	private int carID;
	private int year;
	private String make;
	private String model;
	private double askingPrice;
	private double amtStillOwed;
	
	public Car(){
		super();
	}
	
	public Car(int carID, int year, String make, String model, double askingPrice, double amtStillOwed ) {
		super();
		this.carID = carID;
		this.year = year;
		this.make = make;
		this.model = model;
		this.askingPrice = askingPrice;
		this.amtStillOwed = amtStillOwed;
	}

	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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

	public double getAmtStillOwed() {
		return amtStillOwed;
	}
	public void setAmtStillOwed(double amtStillOwed) {
		this.amtStillOwed = amtStillOwed;
	}

	@Override
	public String toString() {
		return "\n"+ "Car [carID=" + carID + ", year=" + year + ", make=" + make + ", model=" + model + ", askingPrice="
				+ askingPrice + ", amtStillOwed=" + amtStillOwed + "]";
	}
	
	
	
	

}
