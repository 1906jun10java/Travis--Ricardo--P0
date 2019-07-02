package p0.services;

import p0.beans.Customer; 
import p0.beans.DealershipComputerSystem;
import p0.beans.Employee;


public class UserServices {

	// Constructors
	
	// Instance Variables
	
	// Methods
	
	public static boolean EmployeeLogin(String userName, String password, DealershipComputerSystem dealerCompSystem) {
		//
		
		boolean isEmployee = false;
		
		if(dealerCompSystem.employeeAccounts.containsKey(userName)) {
			//String correctPassword = dealerCompSystem.employeeAccounts.get();
			//if(dealerCompSystem.employeeAccounts.get(userName).equals(password) {
		}
		
		return isEmployee;
	}
	
	public static boolean CustomerLogin(String userName, String password, DealershipComputerSystem dealerCompSystem) {
		//
		
		boolean isCustomer = false;
		
		if(dealerCompSystem.customerAccounts.containsKey(userName)) {
			//
		}
		
		return isCustomer;
	}
	
	public static void EmployeeRegister(Employee employee, DealershipComputerSystem dealerCompSystem) {
		//
		dealerCompSystem.employeeAccounts.put(employee.getUserName(), employee);
	}
	
	public static void CustomerRegister(Customer customer, DealershipComputerSystem dealerCompSystem) {
		//
		dealerCompSystem.customerAccounts.put(customer.getUserName(), customer);
	}
}

