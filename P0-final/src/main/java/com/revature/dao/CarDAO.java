package com.revature.dao;

import java.sql.SQLException; 
import java.util.List;

import com.revature.beans.Car;

public interface CarDAO {
	
	public abstract void createCar(int year, String make, String model, double askingPrice, double amtStillOwed)
			throws SQLException;
	
	public abstract List<Car> getCarList()
			throws SQLException;

}
