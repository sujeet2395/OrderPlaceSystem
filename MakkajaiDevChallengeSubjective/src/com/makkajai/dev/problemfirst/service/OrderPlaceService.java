package com.makkajai.dev.problemfirst.service;

import java.util.Scanner;

import com.makkajai.dev.problemfirst.model.Category;
import com.makkajai.dev.problemfirst.model.Order;
import com.makkajai.dev.problemfirst.model.OrderItem;
import com.makkajai.dev.problemfirst.model.Product;

public class OrderPlaceService {
	final static private double basicTax=0.1;
	final static private double importedTax=0.05;
	final static private double roundUpTo=0.05;
	public void placeOrder() {
		Scanner sc =new Scanner(System.in);
		String input;
		String[] words=null;
		int quantity;
		String desc;
		double rate;
		boolean isImported, isFood, isMedical, isBook, isBasic=true;
		char choice='n';
		Order order=new Order();
		
		do {
		System.out.println("Enter the input as describe format[quantity <description contains keyword imported, food chocolate, medicine for exempted otherwise> at <rate>]");
		input=sc.nextLine();
		words=input.split(" ");
		quantity=Integer.parseInt(words[0]);
		rate=Double.parseDouble(words[words.length-1]);
		String inputSmallCase=input.toLowerCase();
		isImported=(inputSmallCase.contains("imported"))?true:false;
		isFood=(inputSmallCase.contains("food") || inputSmallCase.contains("chocolate"))?true:false;
		isMedical=(inputSmallCase.contains("medical") || inputSmallCase.contains("medicine") || inputSmallCase.contains("pill"))?true:false;
		isBook=(inputSmallCase.contains("book"))?true:false;
		if(isFood||isMedical||isBook)
		{
			isBasic=false;
		}
		String description=input.substring(words[0].length(),input.length()-words[words.length-1].length()-3);
		String categoryType=isFood?"FOOD":isBook?"BOOK":isMedical?"MEDICAL":"OTHER";
		
		double price=priceCalculator(rate, quantity, isBasic, isImported);
		double tax=price-quantity*rate;
		order.getItems().add(new OrderItem(quantity, new Product(description,rate, new Category(categoryType)), tax, price));
		//System.out.print(quantity+" "+description+" : "+priceCalculator(rate,quantity,isBasic,isImported));
		System.out.println("\ndo you want to enter more item(y/n)");
		choice=sc.next().charAt(0);
		System.out.println(order.getItems());
		sc.nextLine();
		isBasic=true;
		}while(choice=='y');
		double totalTax=0;
		double totalPrice=0;
		for(OrderItem orderItem : order.getItems()) {
			System.out.println(orderItem.getQuantity()+" "+orderItem.getProduct().getProductDescription()+" : "+orderItem.getPrice());
			totalTax+=orderItem.getTotalTax();
			totalPrice+=orderItem.getPrice();
		}
		totalTax=Math.round(totalTax*100.0)/100.0;
		totalPrice=Math.round(totalPrice*100.0)/100.0;
		System.out.println("\nSales Taxes : "+totalTax);
		System.out.println("Total : "+totalPrice);
		sc.close();
		//System.out.print(priceCalculator(10.00,1,false, true));
		
	}
	public double priceCalculator(double amt, int quant, boolean isBasicTax, boolean isImportedTax)
	{
		double tax=taxCalculator(amt, quant, isBasicTax, isImportedTax);
		double price=quant*amt+tax;
		//System.out.println(price+","+amt+","+tax);
		double roundoffPrice=roundingUptoLimit(price);
		//System.out.println(roundoffPrice+","+amt+","+tax);
		return roundoffPrice;
	}
	public double taxCalculator(double amt, int quant, boolean isBasicTax, boolean isImportedTax)
	{
		double tax=0;
		if(isBasicTax) {
			tax+=quant*amt*basicTax;
		}
		if(isImportedTax)
		{
			tax+=quant*amt*importedTax;
		}
		return tax;
	}
	
	public double roundingUptoLimit(double price)
	{
		double roundoffPrice=Math.round(price*100.0)/100.0; //eg. 14.99, 10.02, 10.62
		// try to make output as in comment line. rounding upto 0.05
		double fraction=roundoffPrice-(int)roundoffPrice; //eg. 0.99, 0.02, 0.62
		double secondDigitFraction=(fraction*100.0 -(int)fraction*100.0)%10; //eg. 9, 2, 2
		//System.out.println("rounding "+roundoffPrice+", "+fraction+", "+ secondDigitFraction);
		if(fraction>0&& secondDigitFraction>0 && secondDigitFraction<5.0)
		{
			roundoffPrice=(((int)(roundoffPrice*10.0))*10.0+5.0)/100.0;//eg. not 0.9, 10.05, 10.65
		}
		return roundoffPrice;
	}
}
