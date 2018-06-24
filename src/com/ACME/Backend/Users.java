package com.ACME.Backend;

public class Users {
	private int userid;
	private String userName;
	private String role;
	private String password;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(int userid, String userName, String role, String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.role = role;
		this.password = password;
	}
	
}
