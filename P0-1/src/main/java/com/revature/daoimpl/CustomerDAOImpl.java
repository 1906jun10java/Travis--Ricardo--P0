package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.dao.CustomerDAO;
import com.revature.utilities.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	private boolean result;
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createCustomer(String firstName, String lastName, String userName, String password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CUSTOMERS VALUES(CUSSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, password);
		ps.executeUpdate();
	}
	
	public int grabCustomerID(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CUSTOMERID FROM CUSTOMERS WHERE USERNAME = "+"'"+username+"' AND PASSWORD = "+"'"+password+"'" );
		int customerID = rs.getInt(1);
		return customerID;
	
	}
	
	public List<Customer> getCustomerList() throws SQLException{
		// Statement compiled on SQL side generally unsafe due to SQL injection
		
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			customerList.add(c);
		}
		
		return customerList;
		
	}
	
	public boolean isCustomer(String username, String password) throws SQLException{
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE USERNAME = "+"'"+username+"' AND PASSWORD = "+"'"+password+"'" );
		Customer c = null;
		while(rs.next()) {
			
			c = new Customer (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			if(c.getUserName().equals(username) && c.getPassword().equals(password)) {
				result = true;
			}else {
				result = false;
			}
	
		}
		return result;
		
	}
	
	
	




}
