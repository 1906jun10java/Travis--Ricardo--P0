package com.revature.mainclass;

import java.sql.SQLException;

import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.OfferDAOImpl;
import com.revature.services.CustomerServices;
import com.revature.services.EmployeeServices;

public class Main {

	public static void main(String[] args) {
		CarDAOImpl cdi = new CarDAOImpl();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		CustomerDAOImpl cudi = new CustomerDAOImpl();
		OfferDAOImpl odi = new OfferDAOImpl();
		EmployeeServices es = new EmployeeServices();
		CustomerServices cs = new CustomerServices();
		MainMenu mm = new MainMenu();
		
		boolean empMenu = false;
		boolean newEmpMenu = false;
		boolean cusMenu = false;
		boolean newCusMenu = false;
		boolean answer = true;
		boolean postEmpLogin = false;
		boolean postCusLogin = false;
		
		while(answer) {
			
			int decision = mm.mainMenu();
			
			if(decision ==1) {
				
				empMenu = es.employeeMenu();
				if(empMenu == false) {
					System.out.println("Wrong credentials, returning you to main menu \n");
					answer = true;
					continue;
				}
				answer = false;
				
			}else if(decision ==2) {
				
				cusMenu = cs.customerMenu();
				if(cusMenu == false) {
					System.out.println("Wrong credentials, returning you to main menu \n");
					answer = true;
					continue;
				}
				answer = false;
				
			}else if(decision ==3){						//new employee or customer will be looped back to main menu
				newEmpMenu = es.newEmployeeMenu();
			} else if(decision ==4){
				newCusMenu = cs.newCustomerMenu();
			}else{
				System.out.println("invalid selection, please try again");
				answer = true;
			}	
		}
		
		//successful logins get funneled below depending on employee or customer
		
		if(empMenu == true) {
			System.out.println("Employee login successful \nPlease choose from menu options below:");
			es.postLoginMenu();
			
		}else if(cusMenu == true) {
			System.out.println("Customer login successful \nPlease choose from menu options below:");
			cs.postLoginMenu();
			
		}
		
		
		
		
		
	/*	int decision = mm.mainMenu();
		if(decision ==1) {
			es.employeeMenu();
		}else if(decision ==2) {
			cs.customerMenu();
		}else {
			System.out.println("invalid selection, please try again");
			
		}*/
		
		
		
		
		//Car functions
		/*		
		try {
			cdi.createCar(2017, "Suzuki", "Jigsaw", 1100, 1100);
		} catch(SQLException e) {
			e.printStackTrace();
		}
								
		try {
			System.out.println(cdi.getCarList());
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	
	
		//Employee functions
		
		try {
			edi.createEmployee("Usain", "Bolt", "quicklike", "lightning");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		 		
		try {
			System.out.println(edi.getEmployeeList());
		} catch(SQLException e) {
			e.printStackTrace();
		}

	
		//Customer functions
		
		try {
			cudi.createCustomer("Billy", "Jean", "loves", "michael");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		try {
			System.out.println(cudi.getCustomerList());
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
		try {
			System.out.println(edi.isEmployee("muss", "buzzoff"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(cudi.isCustomer("E", "IRGenious"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
		try {
			System.out.println(cdi.isCar(2, "Toyota", "Corolla"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		try {
			cdi.removeCar(2, "Toyota", "Corolla");
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		
		try {
			odi.createOffer(77000, 22, 28, "Pending", "Pending");
		} catch(SQLException e) {
			e.printStackTrace();
		}
							
		try {
			System.out.println(odi.getOfferList());
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	
		try {
			odi.acceptOffer(3, 500, "Batman");
		}catch(SQLException e) {
			e.printStackTrace();
		}
			

		
		try {
			System.out.println(odi.getSingleCustomerOffer(26));
		} catch(SQLException e) {
			e.printStackTrace();
		}
*/		
		
	}

}
