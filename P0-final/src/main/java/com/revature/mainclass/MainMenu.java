package com.revature.mainclass;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CarDAOImpl;

public class MainMenu {
	static int decision = 0;
	CarDAOImpl cdi = new CarDAOImpl();
	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		boolean a = true;
		
			System.out.println("Welcome to the main menu, here is our current listing of cars: \n");
			try {
				System.out.println(cdi.getCarList());
			}catch(SQLException e) {
				e.printStackTrace();
			} 
			
			System.out.println("\nHow would you like to proceed? \n");
			System.out.println("Press 1 for Current Employee Services\nPress 2 for Current Customer Services\nPress 3 to register as new Employee\nPress 4 to register as new Customer");
			decision = sc.nextInt();
			
			return decision;	
	}
	

}
