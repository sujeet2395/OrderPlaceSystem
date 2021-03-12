package com.makkajai.dev.problemfirst.model;

import java.util.List;

public class Category {
	private String categoryType;
	//private List<String> categoryItems;
	
	public Category(String categoryType) {
		super();
		this.categoryType = categoryType;
	}

	public Category() {
		super();
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "Category [categoryType=" + categoryType + "]";
	}
	
}
