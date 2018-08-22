/**
 * 
 */
package com.jpmorgan.report;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.trade.Trade;

/**
 * @author ganes
 *
 */
public class ReportImplTest {
	private Map<LocalDate,Double> tradesValueMap;
	private Map<String,Integer> rankMap;
	private List<Trade> tradeList;
	private ReportImpl report;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		report = new ReportImpl();
		tradesValueMap= new TreeMap();
		
		tradesValueMap.put(LocalDate.of(2018,8,18),1234.5);
		tradesValueMap.put(LocalDate.of(2018,7,5), 5678.0);
		tradesValueMap.put(LocalDate.of(2017,12,29), 10000.0);
		
		rankMap= new TreeMap();
		
		rankMap.put("A", 1);
		rankMap.put("B", 2);
		
		Trade order1 = new Trade("foo", "B", (double)0.50, "SGP", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,01,02), (long)200, (double)100.25,(double)50000);
        Trade order2 = new Trade("bar", "S", (double)0.22, "AED", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,01,07), (long)400, (double)150.50,(double)60000);
        Trade order3 = new Trade("foo1", "B", (double)(0.50), "SGP", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,01,04), (long)200, (double)200.25,(double)156738);
        Trade order4 = new Trade("bar1", "S", (double)0.22, "INR", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,01,12), (long)450, (double)50.50,(double)67347);
        Trade order5 = new Trade("foo2", "B", (double)(0.50), "GBP", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,02,02), (long)200, (double)100.25,(double)66768);
        Trade order6 = new Trade("bar", "S", (double)0.22, "JPY", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,03,07), (long)450, (double)150.50,(double)545665);
        Trade order7 = new Trade("foo", "B", (double)(0.50), "SAR", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,01,02), (long)200, (double)200.25,(double)454364);
        Trade order8 = new Trade("bar", "S", (double)0.22, "AED", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,01,07), (long)450, (double)50.50,(double)544543);

        tradeList = Arrays.asList(order1, order2, order3, order4, order5, order6,order7,order8);
		
	}

	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#displayData(java.util.Map)}.
	 */
	@Test
	public void testDisplayData() {
		report.displayData(tradesValueMap);
		assertEquals("Data not displayed correctly",3,tradesValueMap.size());
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#displayData(java.util.Map)}.
	 * Map with different parameters
	 */
	@Test
	public void testDisplayData2() {
		report.displayData(rankMap);
		assertEquals("Data not displayed correctly",2,rankMap.size());
	}

	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByDate(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByDateForBuy() {
		Map tempMap = report.getTradeValuesByDate(tradeList, "B");
		assertEquals("Error populating trades",66768.00,tempMap.get(LocalDate.of(2016,02,02)));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByDate(java.util.List, java.lang.String)}.
	 * Trying to find an entry for tradeType S.
	 */
	@Test
	public void testGetTradeValuesByDateFailForBuy() {
		Map tempMap = report.getTradeValuesByDate(tradeList, "B");
		assertFalse(tempMap.containsKey(LocalDate.of(2016,01,12)));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByDate(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByDateForSell() {
		Map tempMap = report.getTradeValuesByDate(tradeList, "S");
		assertEquals("Error populating trades",60000.00,tempMap.get(LocalDate.of(2016,01,07)));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByDate(java.util.List, java.lang.String)}.
	 * Trying to find an entry for tradeType S.
	 */
	@Test
	public void testGetTradeValuesByDateFailForSell() {
		Map tempMap = report.getTradeValuesByDate(tradeList, "S");
		assertFalse(tempMap.containsKey(LocalDate.of(2016,01,04)));
	}

	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByEntity(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByEntityForBuy() {
		Map tempMap = report.getTradeValuesByEntity(tradeList, "B");
		assertEquals("Error populating trades",2,tempMap.get("foo1"));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByEntity(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByEntityFailForBuy() {
		Map tempMap = report.getTradeValuesByEntity(tradeList, "B");
		assertEquals("Error populating trades",null,tempMap.get("bar1"));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByEntity(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByEntityForSell() {
		Map tempMap = report.getTradeValuesByEntity(tradeList, "S");
		assertEquals("Error populating trades",1,tempMap.get("bar"));
	}
	
	/**
	 * Test method for {@link com.jpmorgan.report.ReportImpl#getTradeValuesByEntity(java.util.List, java.lang.String)}.
	 */
	@Test
	public void testGetTradeValuesByEntityFailForSell() {
		Map tempMap = report.getTradeValuesByEntity(tradeList, "S");
		assertEquals("Error populating trades",null,tempMap.get("foo2"));
	}

	/**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
	@After
    public void tearDown() { 
		tradesValueMap = null;
		rankMap = null;
		tradeList = null;
		report = null; 
    } 

}
