package com.maksymchuk.shopping;

public class Item
{
	public Item(String name, double price)
	{
		this.name = name; 
		this.price = price;
	}
	String name;
	double price = 0;
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
}