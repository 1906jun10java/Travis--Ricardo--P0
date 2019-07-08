package com.revature.beans;

public class Offer {
	
	private int offerID;
	private double offerAmount;
	private int carID;
	private int customerID;
	private String status;
	private String reviewingEmployee;
	
	public Offer() {
		super();
	}
	
	public Offer(int offerID, double offerAmount, int carID, int customerID, String status, String reviewingEmployee) {
		super();
		this.carID = carID;
		this.offerAmount = offerAmount;
		this.carID = carID;
		this.customerID = customerID;
		this.status = status;
		this.reviewingEmployee =reviewingEmployee;
	}

	public int getOfferID() {
		return offerID;
	}

	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReviewingEmployee() {
		return reviewingEmployee;
	}

	public void setReviewingEmployee(String reviewingEmployee) {
		this.reviewingEmployee = reviewingEmployee;
	}

	@Override
	public String toString() {
		return "\n"+ "Offer [offerID=" + offerID + ", offerAmount=" + offerAmount + ", carID=" + carID + ", customerID="
				+ customerID + ", status=" + status + ", reviewingEmployee=" + reviewingEmployee + "]";
	}
	
	
	
}
