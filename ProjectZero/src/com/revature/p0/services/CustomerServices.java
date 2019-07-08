package com.revature.p0.services;

import com.revature.p0.beans.*;

public class CustomerServices {
	
	// Constructors
	
	// Instance Variables
		
	// Methods
		
	public static void viewCarsOnLot(Dealership dealership) {
		
		System.out.println("Viewing all the cars on the lot: ");
		System.out.println();
		
		for(Car car : dealership.carsOnLot) {
			System.out.println(dealership.carsOnLot.indexOf(car) + 1 + 
					". " + car.getYearManufactured() + " " + car.getMake() + 
					" " + car.getModel() + " : $" + car.getAskingPrice());
		}
		System.out.println();
	}
		
	public static void makeOffer(Customer customer, Car car, double amount) {
		
		// Add in functionality to take into account possibility of car not existing
		
		Offer offer = new Offer(customer, car, amount);
		customer.offersMade.add(offer);
		car.offersMadeForCar.add(offer);
		
		System.out.println("You just made this offer: ");
		System.out.println(offer);
		System.out.println();
	}
	
	public static void viewOwnedCars(Customer customer) {
		
		System.out.println("Viewing all cars owned by " + customer.getFirstName() + " " + customer.getLastName() +  ": ");
		
		for(Car car : customer.carsOwned) {
			System.out.println(car);
		}
		System.out.println();
	}
	
	public static void viewRemainingPayments(Customer customer) {
		
		System.out.println("Viewing all monthly payments and remaining balances for cars owned by " + customer.getFirstName() + " " + customer.getLastName() +  ": ");
		
		for(Car car : customer.carsOwned) {
			System.out.println("For the " + car.getYearManufactured() + " " + car.getMake()  + " " + car.getModel() + ": ");
			System.out.println("The amount still owed is: $" + Math.round(car.getAmountStillOwed()*100.00)/100.00);
			System.out.println("The monthly payment is: $" + Math.round(car.getMonthlyPayment()*100.0)/100.0);
		}
		System.out.println();
	}
}
