package com.revature.p0.services;

import java.sql.SQLException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.*;

import com.revature.p0.beans.*;
import com.revature.p0.daoimpl.CustomerDAOImpl;
import com.revature.p0.daoimpl.EmployeeDAOImpl;
import com.revature.p0.services.*;


public class MenuOptionsServices {

	// Constructors
	
	// Instance Variables
	
	static Logger log = LogManager.getLogger(MenuOptionsServices.class);
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	
	public static EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
	
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
		
		// Create and register new employee from user input
		
		try {
			employeeDAOImpl.createEmployee(firstName, lastName, userName, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
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
		
		// Create and register new customer from user input
		
		try {
			customerDAOImpl.createCustomer(firstName, lastName, userName, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			if(employeeDAOImpl.employeeLogin(userName, password)) {
				System.out.println("Login successful!");
				System.out.println();
				
				currentUserEmployee = employeeDAOImpl.getEmployee(userName, password);
				
				employeeMenu();
			}
			else {
				System.out.println("Login unsuccessful.  Please try again.");
				System.out.println();
				
				employeeLoginMenuValidation();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
			System.out.println("Login unsuccessful.  Please try again.");
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
		
		try {
			if(customerDAOImpl.customerLogin(userName, password)) {
				System.out.println("Login successful!");
				System.out.println();
				
				currentUserCustomer = customerDAOImpl.getCustomer(userName, password);
				customerMenu();
			}
			else {
				System.out.println("Login unsuccessful.  Please try again.");
				System.out.println();
				
				customerLoginMenuValidation();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
			System.out.println("Login unsuccessful.  Please try again.");
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
		
		int carID;
		int customerID;
		
		// Print out a list of the cars on the lot so employee can choose a car by Car ID
		
		carID = chooseCarValidation();
		
		if(carID == -1) {
			while(carID == -1) {
				carID = chooseCarValidation();
			}
		}
		
		Car car;
		try {
			car = employeeDAOImpl.getCar(carID);
			
			// Print out a numbered list of offers for the car
			
			customerID = chooseOfferValidation(car);
			
			if(customerID == -1) {
				while(customerID == -1) {
					customerID = chooseOfferValidation(car);
				}
			}
			
			Offer offer;
			try {
				offer = employeeDAOImpl.getOffer(customerID, carID);
				employeeViewOffersMenuValidation(offer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int chooseCarValidation() {
		
		String userInput;
		int defaultVal = 0;
		int carID;
		
		try {
			employeeDAOImpl.viewAllCarsOnLot();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Please enter the Car ID of a car: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				System.out.println();
				System.out.println("Please enter the Car ID of a car: ");
				
				userInput = scanner.nextLine();
				
				carID = tryParse(userInput, defaultVal);
				
				try {
					if (employeeDAOImpl.carExists(carID)==false) {
						carID = -1;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				switch (carID)
				{
					case -1: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						chooseCarValidation(); break;
					default:
						return carID;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			carID = tryParse(userInput, defaultVal);
			
			try {
				if (employeeDAOImpl.carExists(carID)==false) {
					carID = -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			switch (carID)
			{
				case -1: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					chooseCarValidation(); break;
				default:
					return carID;
			}
		}
		return -1;
	}
	
	public static int chooseOfferValidation(Car car) {
		String userInput;
		int defaultVal = 0;
		int customerID;
		
		try {
			employeeDAOImpl.viewOffersForCar(car.getCarID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Please enter the customer ID for the offer you would like to consider: ");
		
		if(scanner.hasNextLine() == false) {
			while (scanner.hasNextLine() == false) {
				
				System.out.println();
				System.out.println("Please enter the customer ID for the offer you would like to consider: ");
				
				userInput = scanner.nextLine();
				
				customerID = tryParse(userInput, defaultVal);
				
				try {
					if (employeeDAOImpl.offerExists(customerID, car.getCarID())==false) {
						customerID = -1;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				switch (customerID)
				{
					case -1: 
						System.out.println();
						System.out.println("Invalid input!");
						System.out.println();
						chooseOfferValidation(car); break;
					default:
						return customerID;
				}
			}
		}
		else {
			
			userInput = scanner.nextLine();
			
			customerID = tryParse(userInput, defaultVal);
			
			try {
				if (employeeDAOImpl.offerExists(customerID, car.getCarID())==false) {
					customerID = -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			switch (customerID)
			{
				case -1: 
					System.out.println();
					System.out.println("Invalid input!");
					System.out.println();
					chooseOfferValidation(car); break;
				default:
					return customerID;
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
		
		try {
			employeeDAOImpl.acceptOffer(offer.getCustomerID(), offer.getCarID(), offer.getAmountWillingToPay());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			employeeDAOImpl.rejectOffer(offer.getCustomerID(), offer.getCarID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		// Create new car from user input and add it to car lot
		
		try {
			employeeDAOImpl.addCarToLot(yearManufactured, make, model, 
					askingPrice, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
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
		
		int carID;
		
		// Print out a list of the cars on the lot so employee can choose a car by Car ID
		
		carID = chooseCarValidation();
				
		if(carID == -1) {
			while(carID == -1) {
				carID = chooseCarValidation();
			}
		}
				
		// Remove the car
		
		try {
			employeeDAOImpl.removeCarFromLot(carID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			employeeDAOImpl.viewAllPayments();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			customerDAOImpl.viewAllCarsOnLot();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		int carID;
		double amount;
		
		// Print out a numbered list of the cars on the lot
		
				System.out.println("Please choose a car from the list below to make an offer on it: ");
				System.out.println();
		
		carID = chooseCarValidation();
		
		if(carID == -1) {
			while(carID == -1) {
				carID = chooseCarValidation();
			}
		}
		
		// Ask customer for amount they want to offer
		
		amount = carOfferPriceValidation();
		
		if(amount == 0) {
			while(amount == 0) {
				amount = carOfferPriceValidation();
			}
		}
		
		// Make the offer
		
		try {
			customerDAOImpl.makeOffer(currentUserCustomer.getUserID(), carID, amount);
		} catch (SQLException e) {
			log.error("Customers can only make one offer per car due to composite primary key constraint");
			e.printStackTrace();
		}
		
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
		
		try {
			customerDAOImpl.viewOwnedCars(currentUserCustomer.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			customerDAOImpl.viewRemainingPayments(currentUserCustomer.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
