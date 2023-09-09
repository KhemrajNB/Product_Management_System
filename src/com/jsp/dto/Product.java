package com.jsp.dto;

public class Product {
	private int id;
	private String name;
	private double price;
	private int stock;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return "{id = "+ id + ", name = " + name + ", Price = " + price +", Phone No. = " + stock +  "}";
	}
	
	
}
