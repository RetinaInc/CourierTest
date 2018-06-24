package com.ACME.Backend;

public class Ticket {
	private int id;
	private int CustomerID;
	private String pickupLocation;
	private String dropLocation;
	private int cost;
	private String datetime;
	private String pickupdatetime;
	private int pkgid;
	private String delivery_person;
	private String assignedTime;
	private String pickedupTime;
	private String deliveredTime;
	private int bonus;
	
	public Ticket(int id, int customerID, String pickuplocation,String droplocation, int cost, String datetime, String pickupdatetime, int pkgid,
			String delivery_person, String assignedTime, String pickedupTime, String deliveredTime, int bonus) {
		super();
		this.id = id;
		CustomerID = customerID;
		pickupLocation = pickuplocation;
		dropLocation=droplocation;
		this.cost = cost;
		this.datetime = datetime;
		this.pickupdatetime = pickupdatetime;
		this.pkgid = pkgid;
		this.delivery_person = delivery_person;
		this.assignedTime = assignedTime;
		this.pickedupTime = pickedupTime;
		this.deliveredTime = deliveredTime;
		this.bonus = bonus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getLocation() {
		return pickupLocation;
	}
	public void setLocation(String location) {
		pickupLocation = location;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getPickupdatetime() {
		return pickupdatetime;
	}
	public void setPickupdatetime(String pickupdatetime) {
		this.pickupdatetime = pickupdatetime;
	}
	public int getPkgid() {
		return pkgid;
	}
	public void setPkgid(int pkgid) {
		this.pkgid = pkgid;
	}
	public String getDelivery_person() {
		return delivery_person;
	}
	public void setDelivery_person(String delivery_person) {
		this.delivery_person = delivery_person;
	}
	public String getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(String assignedTime) {
		this.assignedTime = assignedTime;
	}
	public String getPickedupTime() {
		return pickedupTime;
	}
	public void setPickedupTime(String pickedupTime) {
		this.pickedupTime = pickedupTime;
	}
	public String getDeliveredTime() {
		return deliveredTime;
	}
	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
