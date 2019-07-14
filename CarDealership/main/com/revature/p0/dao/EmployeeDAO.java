package com.revature.p0.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.p0.beans.*;

public interface EmployeeDAO {

	public abstract void createEmployee(String firstName, String lastName, 
			String userName, String password)
			throws SQLException;
	
	public abstract boolean employeeLogin(String userName, String password)
			throws SQLException;
	
	public abstract Employee getEmployee(String userName, String password)
			throws SQLException;
	
	public abstract List<Car> viewAllCarsOnLot() throws SQLException;
	
	public abstract boolean carExists(int carID) throws SQLException;
	
	public abstract boolean customerExists(int customerID) throws SQLException;
	
	public abstract boolean offerExists (int customerID, int carID) throws SQLException;
	
	public abstract Offer getOffer(int customerID, int carID) throws SQLException;
	
	public abstract Car getCar(int carID) throws SQLException;
	
	public abstract void addCarToLot(int year, String make, String model, 
			double askingPrice,  Double monthlyPayment, Integer customerId)
			throws SQLException;
	
	public abstract void removeCarFromLot(int carID)
			throws SQLException;
	
	public abstract List<Offer> viewOffersForCar(int carID)
			throws SQLException;
	
	public abstract void rejectOffer(int customerID, int carID)
			throws SQLException;
	
	public abstract void acceptOffer(int customerID, int carID, double amount)
			throws SQLException;
	
	public List<Car> viewAllPayments() 
			throws SQLException;
}
