package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	public abstract void createCustomer(String firstName, String lastName, String userName, String password)
			throws SQLException;
	
	public abstract List<Customer> getCustomerList()
			throws SQLException;

}
