package com.ACME.Backend;

public class Customer {
	private int customerID;
	private String CustomerName;
	private String Location;
	private String email;
	private String phno;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public Customer(int customerID, String customerName, String location, String email, String phno) {
		super();
		this.customerID = customerID;
		CustomerName = customerName;
		Location = location;
		this.email = email;
		this.phno = phno;
	}
	
}
