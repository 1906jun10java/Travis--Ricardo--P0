package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Employee;
import com.revature.dao.CarDAO;
import com.revature.utilities.ConnFactory;

public class CarDAOImpl implements CarDAO{
	private boolean result;
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createCar(int year, String make, String model, double askingPrice, double amtStillOwed) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CARS VALUES(CARSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setDouble(4, askingPrice);
		ps.setDouble(5, amtStillOwed);
		ps.executeUpdate();
	}
	
	public boolean isCar(int carID, String make, String model) throws SQLException{
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CARS WHERE CARID = " +carID+ "AND MAKE = "+"'"+make+"' AND MODEL = "+"'"+model+"'" );
		Car c = null;
		while(rs.next()) {
			
			c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6));
			if(c.getCarID() == carID && c.getMake().equals(make) && c.getModel().equals(model)) {
				result = true;
			}else {
				result = false;
			}
	
		}
		return result;
		
	}
	
	
	public void removeCar(int carID, String make, String model)throws SQLException{
		
		boolean thisIsACar = isCar(carID, make, model);
		if(thisIsACar == true) {
			Connection conn = cf.getConnection();
			String sql = "DELETE FROM CARS WHERE CARID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, carID);
			ps.execute();
		}
		
		//System.out.println("The "+make+" "+model+" with Car ID: "+carID+ " has been deleted");
	}



	public List<Car> getCarList() throws SQLException {
		// Statement compiled on SQL side generally unsafe due to SQL injection
		
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CARS");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6));
			carList.add(c);
		}
		
		return carList;
	}
	
	

}
