package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Offer;

public interface OfferDAO {
	
	public abstract void createOffer(double offerAmount, int carID, int customerID, String status, String reviewingEmployee)
			throws SQLException;
	
	public abstract List<Offer> getOffersList()
			throws SQLException;
		
	

}
