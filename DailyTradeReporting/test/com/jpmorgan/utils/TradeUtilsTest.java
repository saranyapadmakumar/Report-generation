/**
 * 
 */
package com.jpmorgan.utils;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ganes
 *
 */
public class TradeUtilsTest {
	private TradeUtils tradeUtils;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tradeUtils = new TradeUtils();
	}

	/**
	 * Test method for {@link com.jpmorgan.utils.TradeUtils#calculateUSDAmount(double, long, double)}.
	 */
	@Test
	public void testCalculateUSDAmount() {
		double val = tradeUtils.calculateUSDAmount(0.57, 568, 1460.00);
		assertEquals(472689.6,val,0.01);
		
	}
	

	/**
	 * Test method for {@link com.jpmorgan.utils.TradeUtils#checkWorkingDay(java.lang.String, java.time.LocalDate)}.
	 */
	@Test
	public void testCheckWorkingDay() {
		
		assertEquals("SettlementDate is not correct",LocalDate.of(2018,8,19),tradeUtils.checkWorkingDay("SAR", LocalDate.of(2018,8,18)));
		
	}
	
	@Test
	public void testCheckWorkingDayForNonMiddleEastCurrency() {
		
		assertEquals("SettlementDate is not correct",LocalDate.of(2018,8,20),tradeUtils.checkWorkingDay("EUR", LocalDate.of(2018,8,18)));
		
	}

	/**
	 * Test method for {@link com.jpmorgan.utils.TradeUtils#getDate(java.lang.String)}.
	 */
	@Test
	public void testGetDate() {
		try{
			tradeUtils.getDate("abc");
		}catch(DateTimeParseException e){
			fail("Should raise an Exception");
		}
		
		
	}
	
	@Test
	public void testGetDateForValidInput() {
		try{
			tradeUtils.getDate("18 Aug 2018");
		}catch(DateTimeParseException e){
			fail("Should raise an Exception");
		}
		
		
	}
	
	/**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
	@After
    public void tearDown() { 
    	tradeUtils = null; 
    } 

}
