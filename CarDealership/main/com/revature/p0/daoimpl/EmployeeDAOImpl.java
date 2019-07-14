package com.revature.p0.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.beans.*;
import com.revature.p0.dao.EmployeeDAO;
import com.revature.p0.utilities.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void createEmployee(String firstName, String lastName, 
			String userName, String password) 
					throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO DEALERSHIP_EMPLOYEE VALUES(SQ_CAR_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);
		ps.executeUpdate();
		
		System.out.println("This employee has been registered in our system: ");
		System.out.println("     " + firstName + " " + lastName);
		System.out.println();
	}
	
	public boolean employeeLogin(String username, String password) throws SQLException{
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEALERSHIP_EMPLOYEE WHERE USER_NAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		
		while(rs.next()) {
			
			Employee e = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

			if(e.getUserName().equals(username) && e.getPassword().equals(password)) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;	
	}
	
	public Employee getEmployee(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEALERSHIP_EMPLOYEE WHERE USER_NAME = "+"'"+username+"' AND USER_PASSWORD = "+"'"+password+"'" );
		Employee e = null;
		
		while(rs.next()) {
			e = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		
		return e;	
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
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = "+"'"+carID+"'");
		
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
	
	public boolean customerExists(int customerID) throws SQLException {
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEALERSHIP_CUSTOMER WHERE CUSTOMER_ID = "+"'"+customerID+"'");
		
		while(rs.next()) {
			
			Customer c = new Customer (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			if(c.getUserID() == customerID) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;
	}
	
	public boolean offerExists (int customerID, int carID) throws SQLException {
		
		boolean result = false;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_ID = "+"'"+customerID+"'AND CAR_ID="+"'"+carID+"'");
		
		while(rs.next()) {
			
			Offer o = new Offer(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			if(o.getCustomerID() == customerID & o.getCarID() == carID) {
				result = true;
			}else {
				result = false;
			}
		}
		return result;
	}
	
	public Offer getOffer(int customerID, int carID) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_ID = "+"'"+customerID+"'AND CAR_ID="+"'"+carID+"'");
		Offer o = null;
		
		while(rs.next()) {
			o = new Offer(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
		}
		
		return o;
	}
	
	public Car getCar(int carID) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = "+"'"+carID+"'");
		Car c = null;
		
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
		}
		
		return c;
	}
	
	public void addCarToLot(int year, String make, String model, 
			double askingPrice, Double monthlyPayment, Integer customerId) 
					throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(SQ_CAR_PK.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setDouble(4, askingPrice);
		ps.setNull(5, java.sql.Types.NUMERIC);
		ps.setNull(6, java.sql.Types.NUMERIC);
		ps.executeUpdate();
		
		System.out.println("This car has been added to the lot: ");
		System.out.println("     " + year + " " + make + " " + model + " : $" + askingPrice);
		System.out.println();
	}
	
	public void removeCarFromLot(int carID)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM OFFER WHERE CAR_ID = "+"'"+carID+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		String sql2 = "DELETE FROM CAR WHERE CAR_ID = "+"'"+carID+"'";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.executeUpdate();
		
		System.out.println("A car has been removed from the car lot");
		System.out.println();
		
	}
	
	public List<Offer> viewOffersForCar(int carID)
			throws SQLException {
		
		List<Offer> offerList = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CAR_ID = "+"'"+carID+"'");

		while(rs.next()) {
			Offer o = new Offer(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			offerList.add(o);
		}
		
		for (Offer o : offerList) {
			System.out.println("Customer with ID: " + o.getCustomerID () + 
					" is making an offer of $" + o.getAmountWillingToPay()
					+ " for this car");
		}
		
		return offerList;
	}
	
	public void rejectOffer(int customerID, int carID)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM OFFER WHERE CUSTOMER_ID = "+"'"+customerID+"'AND CAR_ID="+"'"+carID+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		
		System.out.println("An offer has been rejected");
		System.out.println();
	}
	
	public void acceptOffer(int customerID, int carID, double amount)
			throws SQLException {
		Connection conn = cf.getConnection();
		
		// String below refers to a stored procedure:
		
		String sql = "DECLARE P_CUSTOMER_ID NUMBER; P_CAR_ID NUMBER; P_AMOUNT NUMBER;"
				+ "BEGIN ACCEPT_OFFER ('"+customerID+"','"+ carID+"','"+ amount+"');" + 
				"END;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("An offer has been accepted");
		System.out.println();
	}

	public List<Car> viewAllPayments() throws SQLException {
		
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CUSTOMER_ID IS NOT NULL");
		Car c = null;
		
		while(rs.next()) {
			c = new Car(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getInt(7));
			carList.add(c);
		}
		
		for(Car car : carList) {
			System.out.println("* Customer ID: " + car.getCustomerID() + " - $" + car.getAskingPrice() + " still owed"
					+ " with a monthly payment of $" + car.getMonthlyPayment());
		}
		
		System.out.println();
		
		return carList;
	}
}


