package com.makkajai.dev.problemfirst.model;

public class OrderItem {
	private Product product;
	private int quantity;
	private double totalTax;
	private double price;
	
	public OrderItem() {
		super();
	}
	public OrderItem(int quantity, Product product, double totalTax, double price) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.totalTax = totalTax;
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product= product;
	}
	public double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", product=" + product + ", totalTax=" + totalTax + ", price=" + price + "]";
	}
	
	
}

