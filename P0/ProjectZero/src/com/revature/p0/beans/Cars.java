package com.revature.p0.beans;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	
	private int year;
	private String make;
	private String model;
	private double price;
	private static List <Cars> carList = new ArrayList<Cars>();
	private static int numberOfCars = 0;
	
	public Cars (int year, String make, String model, Double price) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;	
	}
	
	public Cars() {			// no arg constructor
		super();
		List <Cars> carList = new ArrayList<Cars>();
		numberOfCars++;
		
	}
	
	//method for printing out all cars on lot:
	public static String carsOnLot() {
		System.out.println("Listing of cars: ");
			return carList.toString();
	}
	
	// method for returning total number of cars:
	public static int totalCars() {
		return numberOfCars;
	}
	
	
				// method for adding cars to Array-list: carList
	public static void addCar(Cars car) {
		carList.add(car);
		numberOfCars++;
	}
	
				// SETTERS and GETTERS for YEAR
	public void setYear(int year) {
		this.year = year;
	}	
	public int getYear() {
		return year;
	}
	
				// SETTERS and GETTERS for MAKE
	public void setMake(String make) {
		this.make = make;
	}
	public String getMake() {
		return make;
	}
	
				// SETTERS and GETTERS for MODEL
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	
				// SETTERS and GETTERS for PRICE
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
				// toString representation
	@Override
	public String toString() {
		return "Cars [year=" + year + ", make=" + make + ", model=" + model + ", price=" + price + "] \n";
	}
	
	
	

}
