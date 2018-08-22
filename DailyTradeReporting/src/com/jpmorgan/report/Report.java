/**
 * 
 */
package com.jpmorgan.report;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.jpmorgan.trade.Trade;

/**
 * @author ganes
 *
 */
public interface Report {
	public static final String INSTRUCTIONTYPE_BUY = "B";
	public static final String INSTRUCTIONTYPE_SELL = "S";
	public static final String HEADER_TOPLINE = 	"****************************************************************";
	public static final String REPORT_HEADER = 		"*                         Trade Report                         *";
	public static final String HEADER_UNDERLINE = 	"****************************************************************";
	public static final String SUBHEADER_BUY = "Amount Settled Out(USD)";
	public static final String SUBHEADER_SETTLEMENTDATE = "Settlement Date";
	public static final String SUBHEADER_SELL = "Amount Settled In(USD)";
	public static final String SUBHEADER_ENTITYNAME = "Entity";
	public static final String SUBHEADER_RANK_BUY = "Rank - Buy";
	public static final String SUBHEADER_RANK_SELL = "Rank - Sell";
	public static final String OUTPUT_FORMAT_STRING = "%-25s%-25s\n";
	public static final String REPORT_DIVIDER = "\n";
	public Map<LocalDate,Double> getTradeValuesByDate(List<Trade> tradeList,String tradeType);
	public Map<String,Integer> getTradeValuesByEntity(List<Trade> tradeList,String tradeType);
	public void displayData(Map valueMap);
}
