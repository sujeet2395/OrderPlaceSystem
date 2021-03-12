package com.makkajai.dev.problemfirst.model;

public class Product {
	private String productDescription;
	private double rate;
	private Category category;
	
	public Product(String productDescription, double rate, Category category) {
		super();
		this.productDescription = productDescription;
		this.rate = rate;
		this.category = category;
	}
	public Product() {
		super();
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productDescription=" + productDescription + ", rate=" + rate + "]";
	}
	
}
