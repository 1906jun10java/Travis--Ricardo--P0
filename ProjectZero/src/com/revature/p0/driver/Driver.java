package com.revature.p0.driver;

import java.util.Arrays;

import com.revature.p0.beans.*;
import com.revature.p0.services.*;

public class Driver {

	public static void main(String[] args) {
		///* Hardcoding trial and error
		
		// Create dealership
		
		Dealership travisAndRicardosAwesomeCars = new Dealership();
		
		// Create employee
		
		User employeeBob = new Employee("Bob", "Smith", "bobsmith2000", "boblovescars");
		
		// Create 3 customers
		
		Customer customerDavid = new Customer("David", "Jones", "dj25498", "239thvs98hf9");
		Customer customerMike = new Customer("Mike", "Williams", "supercoolmike", "mikeissupercool");
		Customer customerSarah = new Customer("Sarah", "Parker", "spiderwoman3000", "S91d3rw0m@n");
		
		// 
		
		// Create 5 cars and add them to the lot
		
		Car porsche911 = new Car(2019, "Porsche", "911", 91100.00);
		Car toyotaCorolla = new Car(2002, "Toyota", "Corolla", 2000.00);
		Car kiaSoul = new Car (2013, "Kia", "Soul", 15175.00);
		Car teslaModelX = new Car (2019, "Tesla", "Model X", 81000);
		Car fordF350 = new Car (2012, "Ford", "F-350", 13950);
		
		EmployeeServices.addCarToLot(porsche911, travisAndRicardosAwesomeCars);
		EmployeeServices.addCarToLot(toyotaCorolla, travisAndRicardosAwesomeCars);
		EmployeeServices.addCarToLot(kiaSoul, travisAndRicardosAwesomeCars);
		EmployeeServices.addCarToLot(teslaModelX, travisAndRicardosAwesomeCars);
		EmployeeServices.addCarToLot(fordF350, travisAndRicardosAwesomeCars);
		
		CustomerServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		// Remove 1 car from the lot
		
		EmployeeServices.removeCarFromLot(toyotaCorolla, travisAndRicardosAwesomeCars);
		
		CustomerServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		// Have customers make offers on cars
		
		CustomerServices.makeOffer(customerDavid, porsche911, 40000);
		CustomerServices.makeOffer(customerDavid, teslaModelX, 40000);
		
		CustomerServices.makeOffer(customerMike, porsche911, 5000);
		CustomerServices.makeOffer(customerMike, teslaModelX, 5000);
		CustomerServices.makeOffer(customerMike, fordF350, 5000);
		CustomerServices.makeOffer(customerMike, kiaSoul, 5000);
		
		CustomerServices.makeOffer(customerSarah, teslaModelX, 75000);
		CustomerServices.makeOffer(customerSarah, kiaSoul, 10000);
		
		// Print out the offers of each customer
		
		// A different way to print out the offers:
		//System.out.println("David's offers: " + Arrays.toString(customerDavid.offersMade.toArray()));
		
		System.out.println("David's offers: ");
		for(Offer offer : customerDavid.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Mike's offers: ");
		for(Offer offer : customerMike.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Sarah's offers: ");
		for(Offer offer : customerSarah.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		// Print out the offers made for each car
		
		System.out.println("Offers made for Porsche: ");
		for(Offer offer : porsche911.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Offers made for Kia: ");
		for(Offer offer : kiaSoul.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Offers made for Tesla: ");
		for(Offer offer : teslaModelX.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Offers made for Ford: ");
		for(Offer offer : fordF350.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		// Have employee accept an offer
		
		EmployeeServices.acceptOffer(teslaModelX.offersMadeForCar.get(2), travisAndRicardosAwesomeCars);
		
		CustomerServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		CustomerServices.viewOwnedCars(customerSarah);
		
		System.out.println("Owner of Tesla: " + teslaModelX.getOwner());
		System.out.println();
		
		System.out.println("Remaining pending offers on Tesla: ");
		for(Offer offer : teslaModelX.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Sarah's offers: ");
		for(Offer offer : customerSarah.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("David's offers: ");
		for(Offer offer : customerDavid.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Mike's offers: ");
		for(Offer offer : customerMike.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		// Have employee reject an offer
		
		EmployeeServices.rejectOffer(porsche911.offersMadeForCar.get(1));
		
		System.out.println("Mike's offers: ");
		for(Offer offer : customerMike.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Remaining pending offers on Porsche: ");
		for(Offer offer : porsche911.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		// Have a customer check their remaining payments for all cars owned
		
		CustomerServices.viewRemainingPayments(customerSarah);
		
		EmployeeServices.viewAllPayments(travisAndRicardosAwesomeCars);
		
		// Have employee accept a second offer
		
		EmployeeServices.acceptOffer(fordF350.offersMadeForCar.get(0), travisAndRicardosAwesomeCars);
		
		CustomerServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		CustomerServices.viewOwnedCars(customerMike);
		
		System.out.println("Owner of Ford: " + fordF350.getOwner());
		System.out.println();
		
		System.out.println("Remaining pending offers on Ford: ");
		for(Offer offer : fordF350.offersMadeForCar) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Sarah's offers: ");
		for(Offer offer : customerSarah.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("David's offers: ");
		for(Offer offer : customerDavid.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		System.out.println("Mike's offers: ");
		for(Offer offer : customerMike.offersMade) {
			System.out.println(offer);
		}
		System.out.println();
		
		CustomerServices.viewRemainingPayments(customerMike);
		
		EmployeeServices.viewAllPayments(travisAndRicardosAwesomeCars);
		
		// */
	}
}
