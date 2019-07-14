package com.revature.p0.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.p0.beans.*;

public interface CustomerDAO {

	public abstract void createCustomer(String firstName, String lastName, 
			String userName, String password)
			throws SQLException;
	
	public abstract Customer getCustomer(String username, String password)
			throws SQLException;
	
	public abstract void makeOffer(int customerID, int carID, double amount)
			throws SQLException;
	
	
	public abstract boolean customerLogin(String userName, String password)
			throws SQLException;
	
	public abstract List<Car> viewAllCarsOnLot() throws SQLException;
	
	public abstract boolean carExists(int carID) throws SQLException;
	
	public abstract Car getCar(int carID) throws SQLException;
	
	public abstract void viewOwnedCars(int customerID) throws SQLException;
	
	public abstract void viewRemainingPayments(int customerID) throws SQLException;
	
}
