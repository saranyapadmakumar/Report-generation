/**
 * 
 */
package com.jpmorgan;

import java.io.IOException;
import java.util.List;

import com.jpmorgan.report.ReportGenerator;
import com.jpmorgan.trade.Trade;
import com.jpmorgan.trade.TradeBO;

/**
 * @author ganes
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TradeBO tradeBO = new TradeBO();
		ReportGenerator reportGen = new ReportGenerator();
		List<Trade> tradeList = tradeBO.processMessage("SampleInput.txt ");
		reportGen.generateReport(tradeList);
		
	}

}
