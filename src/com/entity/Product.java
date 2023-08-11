package com.entity;

public class Product {
	
	private int prod_id;
	private String prod_name;
	private double prod_price; 
	private String prod_quantity;
	
	public Product(int prod_id, String prod_name, double prod_price, String prod_quantity) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}

	public Product(String prod_name, double prod_price, String prod_quantity) {
		super();
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public double getProd_price() {
		return prod_price;
	}

	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(String prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_quantity=" + prod_quantity + "]";
	}
	
	
	
	
	
	
	
}
