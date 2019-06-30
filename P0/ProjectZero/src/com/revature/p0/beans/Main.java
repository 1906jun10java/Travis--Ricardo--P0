package com.revature.p0.beans;
import com.revature.p0.beans.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	 int num = 0;

		
		Scanner sc = new Scanner(System.in);
		
		//making new employees
		Employee employee1 = new Employee ("Nikola", "Tesla", "whatever", "nik", "tester");
		Employee employee2 = new Employee ("Jack", "Jacket", "employee", "jack", "loveJill");
		
		//making new customers
		Customer customer1 = new Customer ("Joe", "Blow", "Customer", "joeB", "loveCars");
		Customer customer2 = new Customer ("Jack", "Beanstalk", "employee", "jB", "loveBeans");
		
		// making new cars
		Cars c1 = new Cars (1995, "Porsche", "Carrera 911", 80000.00);
		Cars c2 = new Cars (2002, "Porsche", "Cayenne", 50000.00);
		Cars c3 = new Cars (2019, "Porsche", "Panamera", 65000.00);
		
		// create a array list 
		//List <Cars> carList = new ArrayList<Cars>();

		
		// add cars to List
		//carList.add(c1);
		Cars.addCar(c2);
		Cars.addCar(c1);
		Cars.addCar(c3);
		
		System.out.println("Amount of cars on lot: " + Cars.totalCars());
		System.out.println(Cars.carsOnLot());
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("List of customers: \n" + customer1 + " \n " + customer2);
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("List of employees: \n" + employee1 + " \n" + employee2 );
		System.out.println("-------------------------------------------------------------");
		
		List <Bids> bidList = new ArrayList<Bids>();
		
		
		//Making a bids instance (in case we don't want to make Bids class abstract
	//	Bids bids = new Bids();
		System.out.println("which car would you like?");
		if( (num = sc.nextInt() ) == 1 ) {
			System.out.println("how much would you like to bid?");
			double money = sc.nextDouble();
		Bids.placeBid(customer1, c1, money);
		}else if( (num = sc.nextInt() ) == 2) {
			System.out.println("how much would you like to bid?");
			double money = sc.nextDouble();
			Bids.placeBid(customer1, c2, money);
		}else {
			System.out.println("you didnt emter the correct response");
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
