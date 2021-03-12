package com.makkajai.dev.problemfirst.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.makkajai.dev.problemfirst.service.OrderPlaceService;

public class TestProblemFirst {
	OrderPlaceService ors =new OrderPlaceService();
	
	@Test
	public void testPriceCalculator_taxExempted()
	{
		assertEquals(12.49, ors.priceCalculator(12.49, 1, false, false),0.05);
		assertEquals(0.85, ors.priceCalculator(0.85, 1, false, false),0.05);
		assertEquals(10.99, ors.priceCalculator(10.99, 1, false, false),0.05);
	}
	@Test
	public void testPriceCalculator_taxBasicOnly()
	{
		assertEquals(16.49, ors.priceCalculator(14.99, 1, true, false),0.05);
		assertEquals(10.75, ors.priceCalculator(9.75, 1, true, false),0.05);
		assertEquals(11.35, ors.priceCalculator(10.31, 1, true, false),0.05);
	}
	@Test
	public void testPriceCalculator_taxImportedOnly()
	{
		assertEquals(29.39, ors.priceCalculator(27.99, 1, false, true),0.05);
		assertEquals(11.85, ors.priceCalculator(11.25, 1, false, true),0.05);
		assertEquals(10.50, ors.priceCalculator(10.00, 1, false, true),0.05);
	}
	@Test
	public void testPriceCalculator_taxImportedAndBasicBoth()
	{
		assertEquals(54.65, ors.priceCalculator(47.50, 1, true, true),0.05);
		assertEquals(32.19, ors.priceCalculator(27.99, 1, true, true),0.05);
		assertEquals(13.25, ors.priceCalculator(11.5, 1, true, true),0.05);
	}
}
