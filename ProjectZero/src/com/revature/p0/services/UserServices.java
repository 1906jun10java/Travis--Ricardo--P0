package com.revature.p0.services;

import com.revature.p0.beans.*;

public class UserServices {

	// Constructors
	
	// Instance Variables
	
	// Methods
	
	public static boolean employeeLogin(String userName, String password, DealershipComputerSystem dealerCompSystem) {
		//
		
		boolean isEmployee = false;
		
		if(dealerCompSystem.employeeAccounts.containsKey(userName)) {
			
			String correctPassword = dealerCompSystem.employeeAccounts.get(userName).getLoginInfo().get(userName);
			
			/*
			System.out.println("Correct password is: " + correctPassword);
			System.out.println();
			*/
			
			if(password.equals(correctPassword)) {
				isEmployee = true;
			}
		}
		
		return isEmployee;
	}
	
	public static boolean customerLogin(String userName, String password, DealershipComputerSystem dealerCompSystem) {
		//
		
		boolean isCustomer = false;
		
		if(dealerCompSystem.customerAccounts.containsKey(userName)) {
			
			String correctPassword = dealerCompSystem.customerAccounts.get(userName).getLoginInfo().get(userName);
			
			if(password.equals(correctPassword)) {
				isCustomer = true;
			}
		}
		
		return isCustomer;
	}
	
	public static void employeeRegister(Employee employee, DealershipComputerSystem dealerCompSystem) {
		//
		dealerCompSystem.employeeAccounts.put(employee.getUserName(), employee);
	}
	
	public static void customerRegister(Customer customer, DealershipComputerSystem dealerCompSystem) {
		//
		dealerCompSystem.customerAccounts.put(customer.getUserName(), customer);
	}
}
