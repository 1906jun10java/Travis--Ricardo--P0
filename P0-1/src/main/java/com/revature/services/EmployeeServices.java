package com.revature.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.OfferDAOImpl;
import com.revature.utilities.ConnFactory;

public class EmployeeServices {
	public EmployeeServices() {
	}
	
	Scanner sc = new Scanner(System.in);
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	CarDAOImpl cdi = new CarDAOImpl();
	OfferDAOImpl odi = new OfferDAOImpl();
	boolean authentication;
	boolean creation;
	boolean postLogin;
	int decision;
	boolean answer = true;
	
	
	
	public boolean employeeMenu() {
		System.out.println("Welcome to login \n");
		System.out.println("Please enter your username now \n");
		String username = sc.nextLine();
		System.out.println("Thanks, please enter password now \n");
		String password = sc.nextLine();
		System.out.println("Validating...");
		
			try {
				authentication = edi.isEmployee(username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return authentication;
			
		
	}
	
	
	public boolean newEmployeeMenu() {
		System.out.println("Welcome to new employee registration \n");
		System.out.println("please enter your employee login number ");

		int loginNumber = 1234;
		int userNumber = sc.nextInt();
		if(loginNumber != userNumber) {
			System.out.println("apologies, you entered wrong info, please close your browser and start again");
			creation = false;
		}else {
			System.out.println("Please enter your first name \n");
			sc.nextLine();
			String firstName = sc.nextLine();
			System.out.println("Please enter you last name");
			String lastName = sc.nextLine();
			sc.nextLine();
			System.out.println("Please enter your username\n");
			String username = sc.nextLine();
			System.out.println("Thanks, please enter password now \n");
			String password = sc.nextLine();
			System.out.println("Creating your account...");
			
			try {
				edi.createEmployee(firstName, lastName, username, password);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("your account has been created, returning you to main menu...\n");
			creation = true;
		}
		
		
		return creation;
	}
	
	
	public void postLoginMenu() {
		System.out.println("Here is the selection of cars again..\n");
		
		try {
			System.out.println(cdi.getCarList());
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		while(answer) {
			
			System.out.println("\nPress 1 to add car to lot\nPress 2 to remove car from lot\nPress 3 to accept a pending offer\n" + 
					"Press 4 to reject a pending offer\nPress 5 to view cars on lot\nPress 6 to LogOut");
					
			decision = sc.nextInt();
					
			if(decision ==1) {
				
				System.out.println("Please enter year");
				int year = sc.nextInt();
				
				System.out.println("Please enter make");
				sc.nextLine();
				String make = sc.nextLine();
				
				System.out.println("Please enter model");
				String model = sc.nextLine();
				
				System.out.println("Please enter Price");
				double askingPrice = sc.nextDouble();
				
				try {
					cdi.createCar(year, make, model, askingPrice, askingPrice);
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("Congratulations, you have added a "+year+" "+make+" "+model+" to the car lot for "+askingPrice+"\n");
				System.out.println("This car will be up form bids immediately.");
						
			}else if(decision ==2) {
				
				System.out.println("You want to remove a car from lot, pleae enter CarID Number");
				int carID = sc.nextInt();
				
				System.out.println("Please enter the Make of car");
				sc.nextLine();
				String make = sc.nextLine();
				
				
				System.out.println("Please enter Model of car");
				
				String model = sc.nextLine();
				
				try {
					cdi.removeCar(carID, make, model);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("Congratulations, you have removed this "+make+" "+model+" from your car lot \n");
						
			}else if(decision ==3) {
				
				System.out.println("Here is a list of pending offers: ");
				
				try {
					System.out.println(odi.getOfferList());
				}catch(SQLException e) {
					e.printStackTrace();
				} 
				
				System.out.println();
				System.out.println("Please enter the Offer ID Number you would like to accept: ");
				int offerID = sc.nextInt();
				
				System.out.println("Please CONFIRM by entering the amount of the offer");
				sc.nextLine();
				double offerAmount = sc.nextDouble();
				
				System.out.println("Enter your full name :");
				sc.nextLine();
				String fullName = sc.nextLine();
				
				try {
					odi.acceptOffer(offerID, offerAmount, fullName);
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				
				
			}else if(decision ==4) {
				
				
				System.out.println("Here is a list of pending offers: ");
				
				try {
					System.out.println(odi.getOfferList());
				}catch(SQLException e) {
					e.printStackTrace();
				} 
				
				System.out.println();
				System.out.println("Please enter the Offer ID Number you would like to reject: ");
				int offerID = sc.nextInt();
				
				System.out.println("Please CONFIRM by entering the amount of the offer");
				sc.nextLine();
				double offerAmount = sc.nextDouble();
				
				System.out.println("Enter your full name :");
				sc.nextLine();
				String fullName = sc.nextLine();
				
				try {
					odi.rejectSingleOffer(offerID, offerAmount, fullName);
				}catch(SQLException e) {
					e.printStackTrace();
				}
	
				
			
			}else if(decision ==5) {
				
				
				try {
					System.out.println(cdi.getCarList());
				}catch(SQLException e) {
					e.printStackTrace();
				} 
				
				
				
			}else if(decision ==6){
				
				answer = false;
				
			}else{
				System.out.println("invalid selection, please try again");
				answer = true;
			}
			
			
			
		}
		
		System.out.println("Thanks for logging out. For security reasons, please close your browser. Goodbye.");
		
	}
	
	
	
		
}
	
	


