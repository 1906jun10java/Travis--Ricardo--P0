package com.revature.p0.services;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.p0.beans.*;
import com.revature.p0.services.*;


public class MenuOptionsServices {

	// Constructors
	
	// Instance Variables
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static Dealership travisAndRicardosAwesomeCars = new Dealership();
	
	public static DealershipComputerSystem dealerCompSystem = new DealershipComputerSystem();
	
	public static Employee currentUserEmployee = new Employee();
	
	public static Customer currentUserCustomer = new Customer();
	
	// Methods
	
	// Create a main menu method to organize all other menus
	
	public static void welcomeMenu() {
		
		System.out.println();
		System.out.println("Welcome to Travis and Ricardo's Awesome Car Lot!");
		System.out.println();
		menu();
		
	}
	
	public static void menu() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Login");
		System.out.println("     2. Customer Login");
		System.out.println("     3. Register For a New Account");
		System.out.println("     4. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Login");
				System.out.println("     2. Customer Login");
				System.out.println("     3. Register For a New Account");
				System.out.println("     4. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						menu(); break;
					case 1: employeeLoginMenu(); break;
					case 2: customerLoginMenu(); break;
					case 3: registrationMenu(); break;
					case 4: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						menu(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					menu(); break;
				case 1: employeeLoginMenu(); break;
				case 2: customerLoginMenu(); break;
				case 3: registrationMenu(); break;
				case 4: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					menu(); break;
			}
		}
	}
	
	// Main Registration Menu
	
	public static void registrationMenu() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Registration");
		System.out.println("     2. Customer Registration");
		System.out.println("     3. Main Menu");
		System.out.println("     4. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Registration");
				System.out.println("     2. Customer Registration");
				System.out.println("     3. Main Menu");
				System.out.println("     4. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						registrationMenu(); break;
					case 1: employeeRegistrationMenu(); break;
					case 2: customerRegistrationMenu(); break;
					case 3: menu(); break;
					case 4: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						registrationMenu(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					registrationMenu(); break;
				case 1: employeeRegistrationMenu(); break;
				case 2: customerRegistrationMenu(); break;
				case 3: menu(); break;
				case 4: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					registrationMenu(); break;
			}
		}
	}
	
	// Employee Registration Menu - Actual Registration
	
	public static void employeeRegistrationMenu() {
		
		System.out.println();
		System.out.println("Please type in your first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Please type in your last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Please type in your username: ");
		String userName = scanner.nextLine();
		System.out.println("Please type in your password: ");
		String password = scanner.nextLine();
		
		// Create new employee from user input
		Employee newEmployee = new Employee(firstName, lastName, userName, password);
		
		// Register the new employee
		UserServices.employeeRegister(newEmployee, dealerCompSystem);
		
		System.out.println();
		System.out.println("You've been registered as an employee!");
		System.out.println();
		
		employeeRegistrationMenuValidation();
		
	}
	
	// Employee Registration Menu - Next Menu Options and User Validation
	
	public static void employeeRegistrationMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Login");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Login");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRegistrationMenuValidation(); break;
					case 1: employeeLoginMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRegistrationMenuValidation(); break;
				}
		
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRegistrationMenuValidation(); break;
				case 1: employeeLoginMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRegistrationMenuValidation(); break;
			}
		}
	}
	
	// Customer Registration Menu - Actual Registration
	
	public static void customerRegistrationMenu() {

		System.out.println();
		System.out.println("Please type in your first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Please type in your last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Please type in your username: ");
		String userName = scanner.nextLine();
		System.out.println("Please type in your password: ");
		String password = scanner.nextLine();
		
		// Create new customer from user input
		Customer newCustomer = new Customer(firstName, lastName, userName, password);
		
		// Register the new customer
		UserServices.customerRegister(newCustomer, dealerCompSystem);
		
		System.out.println();
		System.out.println("You've been registered as a customer!");
		System.out.println();
		
		customerRegistrationMenuValidation();
		
	}
	
	// Customer Registration Menu - Next Menu Options and User Validation
	
	public static void customerRegistrationMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Login");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Login");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerRegistrationMenuValidation(); break;
					case 1: customerLoginMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerRegistrationMenuValidation(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerRegistrationMenuValidation(); break;
				case 1: customerLoginMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerRegistrationMenuValidation(); break;
			}
		}
	}
	
	// Employee Login Menu - Actual Login Page
	
	public static void employeeLoginMenu() {
		
		System.out.println();
		System.out.println("Please type in your username: ");
		String userName = scanner.nextLine();
		System.out.println("Please type in your password: ");
		String password = scanner.nextLine();
		
		if(UserServices.employeeLogin(userName, password, dealerCompSystem)) {
			currentUserEmployee = dealerCompSystem.employeeAccounts.get(userName);
			employeeMenu();
		}
		else {
			System.out.println();
			System.out.println("Incorrect employee login information");
			System.out.println();
			
			employeeLoginMenuValidation();
			
		}
	}
	
	// Employee Login Menu - Next Menu Options and User Validation
	
	public static void employeeLoginMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Login");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Login");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeLoginMenuValidation(); break;
				case 1: employeeLoginMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeLoginMenuValidation(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
			case 0: 
				System.out.println();
				System.out.println("Invalid input!");
				System.out.println();
				employeeLoginMenuValidation(); break;
			case 1: employeeLoginMenu(); break;
			case 2: menu(); break;
			case 3: exit(); break;
			default:
				System.out.println();
				System.out.println("Invalid input!");
				System.out.println();
				employeeLoginMenuValidation(); break;
			}
		}
	}
	
	// Customer Login Menu - Actual Login Page
	
	public static void customerLoginMenu() {
		System.out.println();
		System.out.println("Please type in your username: ");
		String userName = scanner.nextLine();
		System.out.println("Please type in your password: ");
		String password = scanner.nextLine();
		
		if(UserServices.customerLogin(userName, password, dealerCompSystem)) {
			currentUserCustomer = dealerCompSystem.customerAccounts.get(userName);
			customerMenu();
		}
		else {
			
			System.out.println();
			System.out.println("Incorrect customer login information");
			System.out.println();
			
			customerLoginMenuValidation();
		}
	}
	
	// Customer Login Menu - Next Menu Options and User Validation
	
	public static void customerLoginMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Login");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Login");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerLoginMenuValidation(); break;
					case 1: customerLoginMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerLoginMenuValidation(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerLoginMenuValidation(); break;
				case 1: customerLoginMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerLoginMenuValidation(); break;
			}
		}
	}
	
	//********************************************************************************
	
	// Employee Menus
	
	public static void employeeMenu() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. View Offers For Cars on Lot");
		System.out.println("     2. Add Car to Lot");
		System.out.println("     3. Remove Car From Lot");
		System.out.println("     4. View Payments For All Cars Sold");
		System.out.println("     5. Main Menu");
		System.out.println("     6. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. View Offers For Cars on Lot");
				System.out.println("     2. Add Car to Lot");
				System.out.println("     3. Remove Car From Lot");
				System.out.println("     4. View Payments For All Cars Sold");
				System.out.println("     5. Main Menu");
				System.out.println("     6. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeMenu(); break;
					case 1: employeeViewOffers(); break;
					case 2: employeeAddCar(); break;
					case 3: employeeRemoveCar(); break;
					case 4: employeeViewPayments(); break;
					case 5: menu(); break;
					case 6: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeMenu(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeMenu(); break;
				case 1: employeeViewOffers(); break;
				case 2: employeeAddCar(); break;
				case 3: employeeRemoveCar(); break;
				case 4: employeeViewPayments(); break;
				case 5: menu(); break;
				case 6: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeMenu(); break;
			}
		}
	}
	
	public static void employeeViewOffers() {
		
		int carArrayListIndex;
		int offerArrayListIndex;
		
		// Print out a numbered list of the cars on the lot
		
		carArrayListIndex = chooseCarValidation();
		
		if(carArrayListIndex == -1) {
			while(carArrayListIndex == -1) {
				carArrayListIndex = chooseCarValidation();
			}
		}
		
		Car car = travisAndRicardosAwesomeCars.carsOnLot.get(carArrayListIndex);
		
		// Print out a numbered list of offers for the car
		
		offerArrayListIndex = chooseOfferValidation(car);
		
		if(offerArrayListIndex == -1) {
			while(offerArrayListIndex == -1) {
				offerArrayListIndex = chooseOfferValidation(car);
			}
		}
		
		Offer offer = car.offersMadeForCar.get(offerArrayListIndex);
		
		employeeViewOffersMenuValidation(offer);
	}
	
	public static int chooseCarValidation() {
		
		String userInput;
		int defaultVal = 0;
		int carNumberFromMenu;
		int carArrayListIndex;
		
		EmployeeServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		System.out.println();
		System.out.println("Please enter the number of a car: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				System.out.println();
				System.out.println("Please enter the number of a car: ");
				
				userInput = scanner.nextLine();
				
				carNumberFromMenu = tryParse(userInput, defaultVal);
				
				carArrayListIndex = carNumberFromMenu -1;
				
				if (carArrayListIndex < 0 | carArrayListIndex > travisAndRicardosAwesomeCars.carsOnLot.size()) {
					carArrayListIndex = -1;
				}
				
				switch (carArrayListIndex)
				{
					case -1: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						chooseCarValidation(); break;
					default:
						return carArrayListIndex;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			carNumberFromMenu = tryParse(userInput, defaultVal);
			
			carArrayListIndex = carNumberFromMenu -1;
			
			if (carArrayListIndex < 0 | carArrayListIndex > travisAndRicardosAwesomeCars.carsOnLot.size()) {
				carArrayListIndex = -1;
			}
			
			switch (carArrayListIndex)
			{
				case -1: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					chooseCarValidation(); break;
				default:
					return carArrayListIndex;
			}
		}
		return -1;
	}
	
	public static int chooseOfferValidation(Car car) {
		String userInput;
		int defaultVal = 0;
		int offerNumberFromMenu;
		int offerArrayListIndex;
		
		EmployeeServices.viewOffers(car);
		
		System.out.println();
		System.out.println("Please enter the number of an offer you would like to consider: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println();
				System.out.println("Please enter the number of an offer you would like to consider: ");
				
				userInput = scanner.nextLine();
				
				offerNumberFromMenu = tryParse(userInput, defaultVal);
				
				offerArrayListIndex = offerNumberFromMenu -1;
				
				if (offerArrayListIndex < 0 | offerArrayListIndex > car.offersMadeForCar.size()) {
					offerArrayListIndex = -1;
				}
				
				switch (offerArrayListIndex)
				{
					case -1: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						chooseOfferValidation(car); break;
					default:
						return offerArrayListIndex;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			offerNumberFromMenu = tryParse(userInput, defaultVal);
			
			offerArrayListIndex = offerNumberFromMenu -1;
			
			if (offerArrayListIndex < 0 | offerArrayListIndex > car.offersMadeForCar.size()) {
				offerArrayListIndex = -1;
			}
			
			switch (offerArrayListIndex)
			{
				case -1: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					chooseOfferValidation(car); break;
				default:
					return offerArrayListIndex;
			}
		}
		return -1;
	}
	
	public static void employeeViewOffersMenuValidation(Offer offer) {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Accept Offer");
		System.out.println("     2. Reject Offer");
		System.out.println("     3. View Offers For Cars on Lot");
		System.out.println("     4. Employee Menu");
		System.out.println("     5. Main Menu");
		System.out.println("     6. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Accept Offer");
				System.out.println("     2. Reject Offer");
				System.out.println("     3. View Offers For Cars on Lot");
				System.out.println("     4. Employee Menu");
				System.out.println("     5. Main Menu");
				System.out.println("     6. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeViewOffersMenuValidation(offer); break;
					case 1: employeeAcceptOffer(offer); break;
					case 2: employeeRejectOffer(offer); break;
					case 3: employeeViewOffers(); break;
					case 4: employeeMenu(); break;
					case 5: menu(); break;
					case 6: exit(); break;
					default: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeViewOffersMenuValidation(offer); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeViewOffersMenuValidation(offer); break;
				case 1: employeeAcceptOffer(offer); break;
				case 2: employeeRejectOffer(offer); break;
				case 3: employeeViewOffers(); break;
				case 4: employeeMenu(); break;
				case 5: menu(); break;
				case 6: exit(); break;
				default: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeViewOffersMenuValidation(offer); break;
			}
		}
	}
	
	public static void employeeAcceptOffer(Offer offer) {
		
		EmployeeServices.acceptOffer(offer, travisAndRicardosAwesomeCars);
		
		employeeAcceptOfferMenuValidation();
		
	}
	
	public static void employeeAcceptOfferMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. View Offers For Cars on Lot");
		System.out.println("     2. Employee Menu");
		System.out.println("     3. Main Menu");
		System.out.println("     4. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. View Offers For Cars on Lot");
				System.out.println("     2. Employee Menu");
				System.out.println("     3. Main Menu");
				System.out.println("     4. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeAcceptOfferMenuValidation(); break;
					case 1: employeeViewOffers(); break;
					case 2: employeeMenu(); break;
					case 3: menu(); break;
					case 4: exit(); break;
					default: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeAcceptOfferMenuValidation(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeAcceptOfferMenuValidation(); break;
				case 1: employeeViewOffers(); break;
				case 2: employeeMenu(); break;
				case 3: menu(); break;
				case 4: exit(); break;
				default: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeAcceptOfferMenuValidation(); break;
			}
		}
	}
	
	public static void employeeRejectOffer(Offer offer) {
		
		EmployeeServices.rejectOffer(offer);
		
		employeeRejectOfferMenuValidation();
	}
	
	public static void employeeRejectOfferMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. View Offers For Cars on Lot");
		System.out.println("     2. Employee Menu");
		System.out.println("     3. Main Menu");
		System.out.println("     4. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. View Offers For Cars on Lot");
				System.out.println("     2. Employee Menu");
				System.out.println("     3. Main Menu");
				System.out.println("     4. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRejectOfferMenuValidation(); break;
					case 1: employeeViewOffers(); break;
					case 2: employeeMenu(); break;
					case 3: menu(); break;
					case 4: exit(); break;
					default: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRejectOfferMenuValidation(); break;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRejectOfferMenuValidation(); break;
				case 1: employeeViewOffers(); break;
				case 2: employeeMenu(); break;
				case 3: menu(); break;
				case 4: exit(); break;
				default: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRejectOfferMenuValidation(); break;
			}
		}
	}
	
	public static void employeeAddCar() {
		
		int yearManufactured;
		double askingPrice;
		
		yearManufactured = carYearManufacturedValidation();
		
		if(yearManufactured == 0) {
			while(yearManufactured == 0) {
				yearManufactured = carYearManufacturedValidation();
			}
		}
			
		System.out.println("Please type in the make of the car: ");
		String make = scanner.nextLine();
		
		System.out.println("Please type in the model of the car: ");
		String model = scanner.nextLine();
		
		askingPrice = carAskingPriceValidation();
		
		if(askingPrice == 0) {
			while(askingPrice == 0) {
				askingPrice = carAskingPriceValidation();
			}
		}
		
		// Create new car from user input
		Car newCar = new Car(yearManufactured, make, model, askingPrice);
		
		// Add car to lot
		EmployeeServices.addCarToLot(newCar, travisAndRicardosAwesomeCars);
		
		employeeAddCarMenuValidation();
		
	}
	
	public static int carYearManufacturedValidation() {
		
		String userInput;
		int yearManufactured;
		int defaultVal = 0;
		Year now = Year.now();
		int currentYear = Integer.parseInt(now.toString());
		
		System.out.println("Please type the year the car was manufactured: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please type the year the car was manufactured: ");
				
				userInput = scanner.nextLine();
				
				yearManufactured = tryParse(userInput, defaultVal);
				
				if (yearManufactured < 1900 | yearManufactured > currentYear) {
					yearManufactured = 0;
				}
				
				switch (yearManufactured)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						carYearManufacturedValidation();
					default:
						return yearManufactured;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			yearManufactured = tryParse(userInput, defaultVal);
			
			if (yearManufactured < 1900 | yearManufactured > currentYear) {
				yearManufactured = 0;
			}
			
			switch (yearManufactured)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					carYearManufacturedValidation();
				default:
					return yearManufactured;
			}
		}
		return 0;
	}
	
	public static double carAskingPriceValidation() {
		
		String userInput;
		double askingPrice;
		int defaultVal = 0;
		
		System.out.println("Please type in the asking price for the car: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please type in the asking price for the car: ");
				
				userInput = scanner.nextLine();
				
				askingPrice = tryParseDouble(userInput, defaultVal);
				
				if (askingPrice <= 0.0) {
					askingPrice = 0;
				}
				
				switch ((int)askingPrice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						carAskingPriceValidation();
					default:
						return askingPrice;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			askingPrice = tryParseDouble(userInput, defaultVal);
			
			if (askingPrice <= 0.0) {
				askingPrice = 0;
			}
			
			switch ((int)askingPrice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					carAskingPriceValidation();
				default:
					return askingPrice;
			}
		}
		return 0;
		
	}
	
	public static void employeeAddCarMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeAddCarMenuValidation(); break;
					case 1: employeeMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeAddCarMenuValidation(); break;
				}
		
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeAddCarMenuValidation(); break;
				case 1: employeeMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeAddCarMenuValidation(); break;
			}
		}
	}
	
	public static void employeeRemoveCar() {
		
		int carArrayListIndex;
		int offerArrayListIndex;
		
		// Print out a numbered list of the cars on the lot
		
		carArrayListIndex = chooseCarValidation();
		
		if(carArrayListIndex == -1) {
			while(carArrayListIndex == -1) {
				carArrayListIndex = chooseCarValidation();
			}
		}
		
		Car car = travisAndRicardosAwesomeCars.carsOnLot.get(carArrayListIndex);
				
		// Remove the car
		
		EmployeeServices.removeCarFromLot(car, travisAndRicardosAwesomeCars);
		
		employeeRemoveCarMenuValidation();
		
	}
	
	public static void employeeRemoveCarMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRemoveCarMenuValidation(); break;
					case 1: employeeMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeRemoveCarMenuValidation(); break;
				}
		
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRemoveCarMenuValidation(); break;
				case 1: employeeMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeRemoveCarMenuValidation(); break;
			}
		}
	}
	
	public static void employeeViewPayments() {
		
		EmployeeServices.viewAllPayments(travisAndRicardosAwesomeCars);
		
		employeeViewPaymentsMenuValidation();
		
	}
	
	public static void employeeViewPaymentsMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Employee Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
		
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Employee Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeViewPaymentsMenuValidation(); break;
					case 1: employeeMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						employeeViewPaymentsMenuValidation(); break;
				}
		
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeViewPaymentsMenuValidation(); break;
				case 1: employeeMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					employeeViewPaymentsMenuValidation(); break;
			}
		}
	}
	
	//********************************************************************************
	
	// Customer Menus
	
	public static void customerMenu() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. View Cars on Lot");
		System.out.println("     2. Make an Offer on a Car");
		System.out.println("     3. View Cars You Own");
		System.out.println("     4. View Your Remaining Payments");
		System.out.println("     5. Main Menu");
		System.out.println("     6. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. View Cars on Lot");
				System.out.println("     2. Make an Offer on a Car");
				System.out.println("     3. View Cars You Own");
				System.out.println("     4. View Your Remaining Payments");
				System.out.println("     5. Main Menu");
				System.out.println("     6. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerMenu(); break;
					case 1: customerViewCars(); break;
					case 2: customerMakeAnOffer(); break;
					case 3: customerViewOwnedCars(); break;
					case 4: customerViewRemainingPayments(); break;
					case 5: menu(); break;
					case 6: exit(); break;
					default: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerMenu(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerMenu(); break;
				case 1: customerViewCars(); break;
				case 2: customerMakeAnOffer(); break;
				case 3: customerViewOwnedCars(); break;
				case 4: customerViewRemainingPayments(); break;
				case 5: menu(); break;
				case 6: exit(); break;
				default: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerMenu(); break;
			}
		}
	}
	
	public static void customerViewCars() {
		
		// Print out a numbered list of the cars on the lot
		
		CustomerServices.viewCarsOnLot(travisAndRicardosAwesomeCars);
		
		customerViewCarsMenuValidation();
	}
	
	public static void customerViewCarsMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewCarsMenuValidation();
					case 1: customerMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewCarsMenuValidation();
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewCarsMenuValidation();
				case 1: customerMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewCarsMenuValidation();
			}
		}
	}
	
	public static void customerMakeAnOffer() {
		
		int carArrayListIndex;
		double amount;
		
		// Print out a numbered list of the cars on the lot
		
		System.out.println("Please choose a car from the list below to make an offer on it: ");
		System.out.println();
		
		carArrayListIndex = chooseCarValidation();
		
		if(carArrayListIndex == -1) {
			while(carArrayListIndex == -1) {
				carArrayListIndex = chooseCarValidation();
			}
		}
		
		Car car = travisAndRicardosAwesomeCars.carsOnLot.get(carArrayListIndex);
		
		// Ask customer for amount they want to offer
		
		amount = carOfferPriceValidation();
		
		if(amount == 0) {
			while(amount == 0) {
				amount = carOfferPriceValidation();
			}
		}
		
		// Make the offer
		
		CustomerServices.makeOffer(currentUserCustomer, car, amount);
		
		customerMakeAnOfferMenuValidation();
		
	}
	
public static double carOfferPriceValidation() {
		
		String userInput;
		double amount;
		int defaultVal = 0;
		
		System.out.println("Please type in the amount you would like to offer for the car: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please type in the amount you would like to offer for the car: ");
				
				userInput = scanner.nextLine();
				
				amount = tryParseDouble(userInput, defaultVal);
				
				if (amount <= 0.0) {
					amount = 0;
				}
				
				switch ((int)amount)
				{
					case 0: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						carOfferPriceValidation();
					default:
						return amount;
				}
			}
		}
		else {
			userInput = scanner.nextLine();
			
			amount = tryParseDouble(userInput, defaultVal);
			
			if (amount <= 0.0) {
				amount = 0;
			}
			
			switch ((int)amount)
			{
				case 0: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					carOfferPriceValidation();
				default:
					return amount;
			}
		}
		return 0;
		
	}

	public static void customerMakeAnOfferMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerMakeAnOfferMenuValidation(); break;
					case 1: customerMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerMakeAnOfferMenuValidation(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerMakeAnOfferMenuValidation(); break;
				case 1: customerMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerMakeAnOfferMenuValidation(); break;
			}
		}
	}
	
	public static void customerViewOwnedCars() {
		
		CustomerServices.viewOwnedCars(currentUserCustomer);
		
		customerViewOwnedCarsMenuValidation();
		
	}
	
	public static void customerViewOwnedCarsMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewOwnedCarsMenuValidation(); break;
					case 1: customerMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewOwnedCarsMenuValidation(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewOwnedCarsMenuValidation(); break;
				case 1: customerMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewOwnedCarsMenuValidation(); break;
			}
		}
	}
	
	public static void customerViewRemainingPayments() {
		
		CustomerServices.viewRemainingPayments(currentUserCustomer);
		
		customerViewRemainingPaymentsMenuValidation();
		
	}
	
	public static void customerViewRemainingPaymentsMenuValidation() {
		
		String userInput;
		int userMenuOptionChoice;
		int defaultVal = 0;
		
		System.out.println("Please enter the number of the option you would like to choose: ");
		System.out.println("     1. Customer Menu");
		System.out.println("     2. Main Menu");
		System.out.println("     3. Exit");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println("Please enter the number of the option you would like to choose: ");
				System.out.println("     1. Customer Menu");
				System.out.println("     2. Main Menu");
				System.out.println("     3. Exit");
				
				userInput = scanner.nextLine();
				
				userMenuOptionChoice = tryParse(userInput, defaultVal);
				
				switch (userMenuOptionChoice)
				{
					case 0:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewRemainingPaymentsMenuValidation(); break;
					case 1: customerMenu(); break;
					case 2: menu(); break;
					case 3: exit(); break;
					default:
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						customerViewRemainingPaymentsMenuValidation(); break;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			userMenuOptionChoice = tryParse(userInput, defaultVal);
			
			switch (userMenuOptionChoice)
			{
				case 0:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewRemainingPaymentsMenuValidation(); break;
				case 1: customerMenu(); break;
				case 2: menu(); break;
				case 3: exit(); break;
				default:
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					customerViewRemainingPaymentsMenuValidation(); break;
			}
		}
	}
	
	//********************************************************************************
	
	// Exit the program
	
	public static void exit() {
		System.out.println();
		System.out.println("Thanks for visiting Travis and Ricardo's Awesome Car Lot!");
		System.out.println();
		scanner.close();
	}
	
	// Checks to see whether String can successfully be converted to int
	// If not, it returns a default int value, which I set to 0 in the methods above
	
	public static int tryParse(String value, int defaultVal) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return defaultVal;
	    }
	}
	
	// Same as tryParse, but for doubles
	
	public static double tryParseDouble(String value, double defaultVal) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return defaultVal;
	    }
	}
}
