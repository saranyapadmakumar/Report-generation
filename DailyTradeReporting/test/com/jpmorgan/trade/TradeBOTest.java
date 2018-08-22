/**
 * 
 */
package com.jpmorgan.trade;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ganes
 *
 */
public class TradeBOTest {
	private TradeBO tradeBO;
	private List<Trade> trades;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tradeBO = new TradeBO();
		trades = new ArrayList<Trade>();
	}

	/**
	 * Test method for {@link com.jpmorgan.trade.TradeBO#processMessage(java.lang.String)}.
	 */
	@Test
	public void testProcessMessage(){
		try{
			trades = tradeBO.processMessage("SampleInput.txt");
			assertEquals("No of entries does not match",5,trades.size());
		}catch(Exception e){
			System.out.println(e);
			fail("Error reading input File");
		}
		
		
		//fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link com.jpmorgan.trade.TradeBO#processMessage(java.lang.String)}.
	 */
	@Test
	public void testProcessMessageFail(){
		try{
			trades = tradeBO.processMessage(" ");
			assertEquals("No of entries does not match",5,trades.size());
		}catch(IOException e){
			System.out.println(e);
			fail("Error reading input File");
		}
		
		
		//fail("Not yet implemented");
	}

	/**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
	@After
    public void tearDown() { 
    	trades = null; 
    	tradeBO = null;
    } 
}
