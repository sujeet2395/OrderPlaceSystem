package com.makkajai.dev.problemfirst.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderItem> items;

	public Order() {
		super();
		items=new ArrayList<>();
	}

	public Order(List<OrderItem> items) {
		super();
		this.items = items;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [items=" + items + "]";
	}
	
}
