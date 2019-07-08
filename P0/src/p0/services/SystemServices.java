package p0.services;

import p0.beans.Car;
import p0.beans.Offer;
import p0.beans.User;

public class SystemServices {

	// Constructors
	
	// Instance Variables
		
	// Methods
		
	public static void updateOwnership(User user, Car car) {
		
		// Add car to user.carsOwned
		
		user.carsOwned.add(car);
		
		// Set car.owner to user
		
		car.setOwner(user);
	}
		
	public static void rejectPendingOffers(Car car) {
		
		// Remove offer from user.offersMade for all users
		
		for(Offer offer : car.offersMadeForCar) {
			offer.getCustomerMakingOffer().offersMade.remove(offer);
		}
		
		// Remove offer from car.offersMadeForCar
		
		car.offersMadeForCar.clear();
	}
	
	public static void calculateMonthlyPayment(Car car, double payment) {
		
		// Calculate and set the amount still owed by subtracting the payment from what is still owed
		double amountStillOwed = car.getAmountStillOwed() - payment;
		car.setAmountStillOwed(amountStillOwed);
		
		// Calculate and set monthly payment by dividing the amount still owed by 36
		// (For 36 months, or 3 years)
		
		double monthlyPayment = amountStillOwed / 36;
		car.setMonthlyPayment(monthlyPayment);
	}
}

