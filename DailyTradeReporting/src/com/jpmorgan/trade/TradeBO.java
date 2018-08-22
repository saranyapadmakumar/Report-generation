/**
 * 
 */
package com.jpmorgan.trade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.utils.TradeUtils;

/**
 * @author ganes
 *
 */
public class TradeBO {
	
	
	public List<Trade> processMessage(String fileName) throws IOException{
		//String file = fileName;
		TradeUtils tradeUtils = new TradeUtils();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
			String inputLine;
			List<Trade> tradeList = new ArrayList<Trade>();
			
			while ((inputLine = br.readLine()) != null){
				int index = 0;
				String[] tokens = inputLine.split(",");
				String entityName = tokens[index++];
				String tradeType = tokens[index++];
				double fxRate = Double.parseDouble(tokens[index++]);
				String currency = tokens[index++];
				LocalDate instDate = tradeUtils.getDate(tokens[index++]);
				LocalDate settleDate = tradeUtils.checkWorkingDay(currency,tradeUtils.getDate(tokens[index++]));
				long units = Long.parseLong(tokens[index++]);
				double pricePerUnit = Double.parseDouble(tokens[index]);					
				Trade trade = new Trade(entityName,tradeType,fxRate,currency,instDate,settleDate,
											units,pricePerUnit,tradeUtils.calculateUSDAmount(fxRate, units, pricePerUnit));
				tradeList.add(trade);
			}
			br.close();
			return tradeList;
		
	}

}
