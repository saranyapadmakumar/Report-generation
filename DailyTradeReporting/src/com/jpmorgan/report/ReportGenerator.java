/**
 * 
 */
package com.jpmorgan.report;

import java.util.List;

import com.jpmorgan.trade.Trade;

/**
 * @author ganes
 *
 */
public class ReportGenerator {

	Report tradeReport = new ReportImpl();
	
	public void generateReport(List<Trade> tradeList){
		
		System.out.println(Report.HEADER_TOPLINE);
		System.out.println(Report.REPORT_HEADER);
		System.out.println(Report.HEADER_UNDERLINE);
		System.out.format(Report.OUTPUT_FORMAT_STRING, Report.SUBHEADER_SETTLEMENTDATE,Report.SUBHEADER_SELL);
		tradeReport.displayData(tradeReport.getTradeValuesByDate(tradeList,Report.INSTRUCTIONTYPE_SELL));
		System.out.println(Report.REPORT_DIVIDER);
		System.out.format(Report.OUTPUT_FORMAT_STRING, Report.SUBHEADER_SETTLEMENTDATE,Report.SUBHEADER_BUY);
		tradeReport.displayData(tradeReport.getTradeValuesByDate(tradeList,Report.INSTRUCTIONTYPE_BUY));
		System.out.println(Report.REPORT_DIVIDER);
		System.out.format(Report.OUTPUT_FORMAT_STRING,Report.SUBHEADER_ENTITYNAME,Report.SUBHEADER_RANK_SELL);
		tradeReport.displayData(tradeReport.getTradeValuesByEntity(tradeList,Report.INSTRUCTIONTYPE_SELL));
		System.out.println(Report.REPORT_DIVIDER);
		System.out.format(Report.OUTPUT_FORMAT_STRING,Report.SUBHEADER_ENTITYNAME,Report.SUBHEADER_RANK_BUY);
		tradeReport.displayData(tradeReport.getTradeValuesByEntity(tradeList,Report.INSTRUCTIONTYPE_BUY));
		
	}
}
