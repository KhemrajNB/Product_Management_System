package com.jsp.dto;

public class Customer {
	private int id;
	private String name;
	private String email;
	private long ph_no;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPh_no() {
		return ph_no;
	}
	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}
	
	public String toString() {
		return "{id = "+ id + ", name = " + name + ", email = " + email +", Phone No. = " + ph_no +  "}";
	}
	
	
}
