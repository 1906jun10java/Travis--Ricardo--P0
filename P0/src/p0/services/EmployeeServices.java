package p0.services;

import p0.beans.Car;
import p0.beans.Dealership;
import p0.beans.Offer;
import p0.services.EmployeeServices;
import p0.services.SystemServices;

public class EmployeeServices {

	// Constructors
	
	// Instance Variables
			
	// Methods
			
	public static void addCarToLot(Car car, Dealership dealership) {
		
		// System changes ownership to dealership
		
		SystemServices.updateOwnership(dealership, car);
		
		// Add car to dealership.carsOnLot
		
		dealership.carsOnLot.add(car);
		System.out.println("This car was added to the lot: " + car);
		System.out.println();
	}
	
	public static void removeCarFromLot(Car car, Dealership dealership) {
		
		/*Checks to see if car is in dealership.carsOnLot
		 * Removes from carsOnLot if it is present
		 * Prints a message to screen if not found
		 */
		
		if(dealership.carsOnLot.contains(car)) {
			dealership.carsOnLot.remove(car);
			System.out.println("This car was removed from the lot: " + car);
			System.out.println();
		}
		else {
			System.out.println("This car was not found on the lot: " + car);
			System.out.println();
		}
		
	}
	
	public static void acceptOffer(Offer offer, Dealership dealership) {
		
		// Employee takes the car off the lot
		
		EmployeeServices.removeCarFromLot(offer.getCarDesired(), dealership);
		
		// System changes ownership to customer making offer
		
		SystemServices.updateOwnership(offer.getCustomerMakingOffer(), offer.getCarDesired());
		
		// System reduces amount due on car by amount of offer
		// and calculates monthly payment based on amount still due
		
		SystemServices.calculateMonthlyPayment(offer.getCarDesired(), offer.getAmountWillingToPay());
		
		// Adds the car to dealership.carsSold to keep track of payments
		
		dealership.carsSold.add(offer.getCarDesired());
		
		// System deletes the offer and all other offers on that Car and
		// removes offer from customer's list of offers
		
		SystemServices.rejectPendingOffers(offer.getCarDesired());
		
	}
			
	public static void rejectOffer(Offer offer) {
	
		System.out.println("This offer has been rejected: " + offer);
		System.out.println();
		
		// Offer is removed from car.offersMadeForCar
		offer.getCarDesired().offersMadeForCar.remove(offer);
		
		// Offer is removed from customer.offersMade
		offer.getCustomerMakingOffer().offersMade.remove(offer);
		
	}
	
	public static void viewAllPayments(Dealership dealership) {
		//
		
		System.out.println("Viewing all remaining payments for cars sold by dealership: ");
		System.out.println();
		
		for(Car car : dealership.carsSold) {
			System.out.println("For the " + car.getYearManufactured() + " " + car.getMake()  + " " + car.getModel() 
					+ " owned by " + car.getOwner().getFirstName() + " " + car.getOwner().getLastName() + ": ");
			System.out.println("The amount still owed is: $" + Math.round(car.getAmountStillOwed()*100.00)/100.00);
			System.out.println("The monthly payment is: $" + Math.round(car.getMonthlyPayment()*100.0)/100.0);
			System.out.println();
		}
		System.out.println();
	}
}

