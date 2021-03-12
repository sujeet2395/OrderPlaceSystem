package com.makkajai.dev.problemfirst.driver;

import com.makkajai.dev.problemfirst.service.OrderPlaceService;

public class ProblemMainClass {
	public static void main(String[] args) {
		OrderPlaceService ors=new OrderPlaceService();
		ors.placeOrder();
	}
}
