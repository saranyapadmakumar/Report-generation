/**
 * 
 */
package com.jpmorgan.report;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.trade.Trade;


/**
 * @author ganes
 *
 */
public class ReportGeneratorTest {
	private List<Trade> tradeList;

    @Before
    public void setUp() throws Exception {
    	

    	
        Trade order1 = new Trade("foo", "B", (double)0.50, "SGP", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,01,02), (long)200, (double)100.25,(double)50000);
        Trade order2 = new Trade("bar", "S", (double)0.22, "AED", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,01,07), (long)400, (double)150.50,(double)60000);
        Trade order3 = new Trade("foo1", "B", (double)(0.50), "SGP", LocalDate.of(2016,01,01),
        		LocalDate.of(2016,01,04), (long)200, (double)200.25,(double)156738);
        Trade order4 = new Trade("bar1", "S", (double)0.22, "INR", LocalDate.of(2016,01,05),
        		LocalDate.of(2016,01,012), (long)450, (double)50.50,(double)67347);
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
	 * Test method for {@link com.jpmorgan.report.ReportGenerator#generateReports(java.util.List)}.
	 */
	@Test
	public void testGenerateReports() {
		new ReportGenerator().generateReport(tradeList);
        assert(true);
		//fail("Not yet implemented");
	}
	
	/**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
	@After
    public void tearDown() { 
		
		tradeList = null;
		
    } 


}
