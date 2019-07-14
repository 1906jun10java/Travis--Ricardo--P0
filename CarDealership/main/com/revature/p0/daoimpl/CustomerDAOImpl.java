package com.revature.p0.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.beans.*;
import com.revature.p0.dao.CustomerDAO;
import com.revature.p0.utilities.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createCustomer(String firstName, String lastName, 
			String userName, String password) 
					throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO DEALERSHIP_CUSTOMER VALUES(SQ_CAR_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);
		ps.executeUpdate();
		
		System.out.println("This customer has been registered in our system: ");
		System.out.println("     " + firstName + " " + lastName);
		System.out.println();
	}
	
	public Customer getCustomer(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEALERSHIP_CUSTOMER WHERE USER_NAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		Customer c = null;
		
		while(rs.next()) {
			c = new Customer (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		
		return c;
	}
	
	public void makeOffer(int customerID, int carID, double amount)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFER VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customerID);
		ps.setInt(2, carID);
		ps.setDouble(3, amount);
		ps.executeUpdate();
		
		System.out.println("Your offer has been registered in our system.");
		System.out.println();
	}
	
	public boolean customerLogin(String username, String password) throws SQLException{
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEALERSHIP_CUSTOMER WHERE USER_NAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		
		while(rs.next()) {
			
			Customer c = new Customer (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			if(c.getUserName().equals(username) && c.getPassword().equals(password)) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;
	}
	
	public List<Car> viewAllCarsOnLot() throws SQLException {
		
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CUSTOMER_ID IS NULL");
		
		while(rs.next()) {
			Car c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			carList.add(c);
		}
		
		for(Car car : carList) {
			System.out.println("* " + car + " - $" + car.getAskingPrice());
		}
		
		System.out.println();
		
		return carList;
	}
	
	public boolean carExists(int carID) throws SQLException{
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = " +carID+"'");
		
		while(rs.next()) {
			
			Car c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			if(c.getCarID() == carID) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;
	}
	
	public Car getCar(int carID) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = " +carID+"'");
		Car c = null;
		
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
		}
		
		return c;
	}

	public void viewOwnedCars(int customerID) throws SQLException {
		
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CUSTOMER_ID = "+"'"+customerID+"'");
		
		while(rs.next()) {
			Car c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			carList.add(c);
		}
		
		for(Car car : carList) {
			System.out.println("Your cars: ");
			System.out.println("* " + car);
			System.out.println();
		}
	}
	
	public void viewRemainingPayments(int customerID) throws SQLException {
		
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CUSTOMER_ID = "+"'"+customerID+"'");
		
		while(rs.next()) {
			Car c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			carList.add(c);
		}
		
		for(Car car : carList) {
			System.out.println("Your remaining payments: ");
			System.out.println("* " + car + " : $" + car.getAskingPrice() + " remaining"
					+ " with a monthly payment of $" + car.getMonthlyPayment());
			System.out.println();
		}
	}
}
