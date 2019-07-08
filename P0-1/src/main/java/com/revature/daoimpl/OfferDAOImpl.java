package com.revature.daoimpl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.beans.Offer;
import com.revature.utilities.ConnFactory;



public class OfferDAOImpl {
	private boolean result;
	public static ConnFactory cf = ConnFactory.getInstance();
	Scanner sc = new Scanner(System.in);
	
	
	public void createOffer(double offerAmount, int carID, int customerID, String status, String reviewingEmployee) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(OFFSEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, offerAmount);
		ps.setInt(2, carID);
		ps.setInt(3, customerID);
		ps.setString(4, status);
		ps.setString(5, reviewingEmployee);
		ps.executeUpdate();
	}
	
	
	public List<Offer> getOfferList() throws SQLException{
		// Statement compiled on SQL side generally unsafe due to SQL injection

		List<Offer> offerList = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS");
		Offer o = null;
		while(rs.next()) {
			o = new Offer(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			offerList.add(o);
		}
		
		return offerList;
		
	} 
	
	
	public List<Offer> getSingleCustomerOffer(int customerID) throws SQLException{
		List<Offer> offerList = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS WHERE CUSTOMERID = "+customerID);
		Offer o = null;
		while(rs.next()) {
			o = new Offer(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			offerList.add(o);
		}
		
		return offerList;
	}
	
	
	public boolean isOffer(int offerID, double offerAmount) throws SQLException{
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS WHERE OFFERID = "+"'"+offerID+"' AND OFFERAMOUNT = "+"'"+offerAmount+"'" );
		Offer o = null;
		while(rs.next()) {
			
			o = new Offer(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			if( (o.getOfferID() == offerID) && ( o.getOfferAmount() == offerAmount) ) {
				result = true;
			}else {
				result = false;
			}
	
		}
		return result;
		
	}
	
	
	public boolean acceptOffer(int offerID, double offerAmount, String fullName)throws SQLException{
		String decision = "accepted";
		boolean thisIsAOffer = isOffer(offerID, offerAmount);
		if(thisIsAOffer == true) {
			Connection conn = cf.getConnection();
			String sql = "UPDATE OFFERS SET STATUS = ? , REVIEWINGEMPLOYEE = ? WHERE OFFERID = " +offerID+ " AND OFFERAMOUNT = "+offerAmount;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, decision);
			ps.setString(2, fullName);
			System.out.println("Thank you "+ fullName+ " you have " +decision+ " offer of "+offerAmount+" on vehicle ");
			 return true;
		}else {
			System.out.println("you have made a mistake, please try again");
			return false;
			//now loop back around! -- implements this somehow!
		}
		
	}
	
	
	public boolean rejectSingleOffer(int offerID, double offerAmount, String fullName)throws SQLException{
		String decision = "rejected";
		boolean thisIsAOffer = isOffer(offerID, offerAmount);
		if(thisIsAOffer == true) {
			Connection conn = cf.getConnection();
			String sql = "UPDATE OFFERS SET STATUS = ? , REVIEWINGEMPLOYEE = ? WHERE OFFERID = " +offerID+ " AND OFFERAMOUNT = "+offerAmount;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, decision);
			ps.setString(2, fullName);
			System.out.println("Thank you "+ fullName+ " you have " +decision+ " offer of "+offerAmount+" on vehicle ");
			 return true;
		}else {
			System.out.println("you have made a mistake, please try again");
			return false;
			//now loop back around! -- implements this somehow!
		}
		
	}
	
	
	public void rejectOtherOffers(int offerID, double offerAmount, String fullName, int carID) throws SQLException {
		String decision = "rejected";
		boolean anotherOfferAccepted = acceptOffer(offerID, offerAmount, fullName);
		if(anotherOfferAccepted == true) {
			Connection conn = cf.getConnection();
			String sql = "UPDATE OFFERS SET STATUS = ? , REVIEWINGEMPLOYEE = ? WHERE OFFERID != " +offerID+ " AND CARID = "+carID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, decision);
			ps.setString(2, fullName);
			System.out.println("All other offers have been rejected on Car ID: " + carID);
		}
		System.out.println("There was no need to reject any other offers");
		 
	}
	


	

}
