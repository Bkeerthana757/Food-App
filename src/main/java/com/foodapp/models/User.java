package com.foodapp.models;

import java.sql.Timestamp;

public class User {
	 private int userid;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phonenumber;
	private String address;
	private String role;
	private Timestamp created_Date;
	private Timestamp last_login_date;
			
		
	

	public User(int userid, String name, String username, String password, String email, String phonenumber,
			String address, String role, Timestamp created_Date, Timestamp last_login_date) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
		this.created_Date = created_Date;
		this.last_login_date = last_login_date;
	}
	
	public User(int userid, String name,String username, String password, String email, String phonenumber,
			String address,String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.username=username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}
	


	public User(int userid, String name,String password, String email, String phonenumber,
			String address, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Timestamp created_Date) {
		this.created_Date = created_Date;
	}

	public Timestamp getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}

	@Override
	public String toString() {
		return "User:[" + name +" "+ username+" "+ password +" "+ address+"]";
	}
	

}
