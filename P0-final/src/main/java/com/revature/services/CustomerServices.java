package com.revature.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.OfferDAOImpl;
import com.revature.utilities.ConnFactory;

public class CustomerServices {
	
	Scanner sc = new Scanner(System.in);
	public CustomerServices() {}
	CustomerDAOImpl cudi = new CustomerDAOImpl();
	CarDAOImpl cdi = new CarDAOImpl();
	OfferDAOImpl odi = new OfferDAOImpl();

	boolean authentication;
	boolean creation;
	boolean answer = true;
	int decision;
	static int staticCustomerID;
	
	
	
	
	
	public boolean customerMenu() {
		
		System.out.println("Welcome to Customer login \n");
		System.out.println("Please enter your username now \n");
		String username = sc.nextLine();
		System.out.println("Thanks, please enter password now \n");
		String password = sc.nextLine();
		System.out.println("Validating...");
		
			try {
				authentication = cudi.isCustomer(username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return authentication;
		
	}
	
	
	
	public boolean newCustomerMenu() {
		System.out.println("Welcome to new customer registration \n");
		
			System.out.println("Please enter your first name \n");
			//sc.nextLine();
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
				cudi.createCustomer(firstName, lastName, username, password);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("your account has been created, returning you to main menu...\n");
			creation = true;
		
		
		
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
			
			System.out.println("\nPress 1 to place bid on a car\nPress 2 to view all your bids\nPress 3 to view the car(s) that you own\n" 
					+ "Press 4 to view remaining payments on a car\nPress 5 to view cars for sale\nPress 6 to LogOut");
					
			decision = sc.nextInt();
					
			if(decision ==1) {
				
				/*System.out.println("Creating offer ...\n");
				System.out.println("Please enter your personal Customer ID\n");
				//int customerID = 
*/				
				System.out.println("Please enter the Car ID Number\n");
				sc.nextLine();
				int carID = sc.nextInt();
				
				System.out.println("Please enter the amount you would like to bid for this car\n");
				sc.nextLine();
				double offerAmount = sc.nextDouble();
				
				try {
					odi.createOffer(offerAmount, carID, staticCustomerID, "Pending", "Pending");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("Congratulations, you have placed a bid of "+offerAmount+" on car with carID: "+carID);
				
			}else if(decision ==2) {
				
				//.out.println("Please enter your Customer ID Number");
				//int customerID = sc.nextInt();
				
				try {
					System.out.println(odi.getSingleCustomerOffer(staticCustomerID));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
	
	

}
