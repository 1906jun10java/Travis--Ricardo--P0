package com.revature.p0.driver;

import java.util.Arrays;

import com.revature.p0.beans.*;
import com.revature.p0.services.*;

public class Driver {

	public static void main(String[] args) {
		
		//MenuOptionServices.
		
		//Hardcoding trial and error
		
		// Create dealership
		
		Dealership travisAndRicardosAwesomeCars = new Dealership();
		
		// Create dealership computer system
		
		DealershipComputerSystem dealerCompSystem = new DealershipComputerSystem();
		
		// Create employee
		
		Employee employeeBob = new Employee("Bob", "Smith", "bobsmith2000", "boblovescars");
		
		// Have employee register as an employee
		
		UserServices.employeeRegister(employeeBob, dealerCompSystem);
		
		System.out.println("Listing all employee accounts: ");
		for (String employeeAccountUserName : dealerCompSystem.employeeAccounts.keySet()) {
			System.out.println(employeeAccountUserName + " : " + dealerCompSystem.employeeAccounts.get(employeeAccountUserName));
			System.out.println();
		}
		
		// Have employee try to login as an employee
		
		System.out.println("Was Bob able to successfully register and login as an employee?");
		System.out.println(UserServices.employeeLogin("bobsmith2000", "boblovescars", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Bob able to successfully login as an employee with the wrong password?");
		System.out.println(UserServices.employeeLogin("bobsmith2000", "bobhatescars", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Bob able to successfully login as a customer?");
		System.out.println(UserServices.customerLogin("bobsmith2000", "boblovescars", dealerCompSystem));
		System.out.println();
		
		// Create 3 customers
		
		Customer customerDavid = new Customer("David", "Jones", "dj25498", "239thvs98hf9");
		Customer customerMike = new Customer("Mike", "Williams", "supercoolmike", "mikeissupercool");
		Customer customerSarah = new Customer("Sarah", "Parker", "spiderwoman3000", "S91d3rw0m@n");
		
		// Have customers register as customers
		
		UserServices.customerRegister(customerDavid, dealerCompSystem);
		UserServices.customerRegister(customerMike, dealerCompSystem);
		UserServices.customerRegister(customerSarah, dealerCompSystem);
		
		System.out.println("Listing all customer accounts: ");
		for (String customerAccountUserName : dealerCompSystem.customerAccounts.keySet()) {
			System.out.println(customerAccountUserName + " : " + dealerCompSystem.customerAccounts.get(customerAccountUserName));
			System.out.println();
		}
		
		// Have customers try to login as a customer
		
		System.out.println("Was David able to successfully register and login as a customer?");
		System.out.println(UserServices.customerLogin("dj25498", "239thvs98hf9", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Mike able to successfully register and login as a customer?");
		System.out.println(UserServices.customerLogin("supercoolmike", "mikeissupercool", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Sarah able to successfully register and login as a customer?");
		System.out.println(UserServices.customerLogin("spiderwoman3000", "S91d3rw0m@n", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Sarah able to successfully login as a customer with wrong password?");
		System.out.println(UserServices.customerLogin("spiderwoman3000", "spiderwoman", dealerCompSystem));
		System.out.println();
		
		System.out.println("Was Sarah able to successfully login as an employee?");
		System.out.println(UserServices.employeeLogin("spiderwoman3000", "S91d3rw0m@n", dealerCompSystem));
		System.out.println();
		
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
		
		//*/
	}
}
