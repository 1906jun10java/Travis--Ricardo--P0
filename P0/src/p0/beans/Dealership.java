package p0.beans;

import java.util.ArrayList;
import p0.beans.Car;
import p0.beans.User;

public class Dealership extends User {

	// Constructors
	
	// Instance Variables
	
	public ArrayList<Car> carsOnLot = new ArrayList<Car>();
	
	public ArrayList<Car> carsSold = new ArrayList<Car>(); // maybe need this to keep track of payments?
		
		
	// Getters & Setters
	
	/*
	public ArrayList<Car> getCarsOnLot(ArrayList<Car> carsOnLot) {
		this.carsOnLot = carsOnLot;
		return carsOnLot;
	}
	*/
}