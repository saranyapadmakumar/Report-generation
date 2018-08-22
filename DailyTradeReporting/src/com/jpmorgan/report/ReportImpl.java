/**
 * 
 */
package com.jpmorgan.report;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


import com.jpmorgan.trade.Trade;


/**
 * @author ganes
 *
 */
public class ReportImpl implements Report {
	
	
	public void displayData(Map valueMap){
		valueMap.forEach((k,v)->System.out.format(OUTPUT_FORMAT_STRING,k, v));
		
	}
			
	public Map<LocalDate,Double> getTradeValuesByDate(List<Trade> tradeList,String tradeType) {
		// TODO Auto-generated method stub
		
		Map<LocalDate,Double> tradesValueMap= new TreeMap();
		for(Trade t: tradeList){
			if (t.getInstructionType().equalsIgnoreCase(tradeType)) {
				LocalDate dateKey = t.getSettlementDate();
				double tradeAmount = t.getTotalAmount();
				if (tradesValueMap.get(dateKey) != null) {
					tradeAmount += tradesValueMap.get(dateKey);
				}else{
					tradesValueMap.put(dateKey, tradeAmount);
				}
			}
		}
		
		return tradesValueMap;
	}
	
	public Map<String,Integer> getTradeValuesByEntity(List<Trade> tradeList,String tradeType) {
		// TODO Auto-generated method stub
		
		Map<String,Double> entityValueMap= new TreeMap();
		
		for(Trade t: tradeList){
			if (t.getInstructionType().equalsIgnoreCase(tradeType)) {
				String entityKey = t.getEntityName();
				double tradeAmount = t.getTotalAmount();
				if (entityValueMap.get(entityKey) != null) {
					tradeAmount += entityValueMap.get(entityKey);
					entityValueMap.replace(entityKey, tradeAmount);
				}else{
					entityValueMap.put(entityKey, tradeAmount);
				}
			}
		}
		
		return getEntityRank(sortByDescendingValue(entityValueMap));
	
	}
	private Map<String, Integer> getEntityRank(Map<String,Double> entityValueMap){

		Map<String,Integer> rankMap = new HashMap();
		int prevRank = 0;
		int currentRank = 0;
		double previousValue = 0.0;
		for (Map.Entry<String, Double> entry : entityValueMap.entrySet()){
			if(entry.getValue() != previousValue){
				prevRank++;
				currentRank++;
			}else{
				//previousValue = entry.getValue();		
			}
			previousValue = entry.getValue();
			rankMap.put(entry.getKey(), currentRank);
			
		}
		Map<String, Integer> result2 = new LinkedHashMap<>();
		rankMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		return sortByAscendingValue(rankMap);
		
	}
	
	private <K, V extends Comparable<? super V>> Map<K, V> sortByDescendingValue(
				Map<K, V> unsortedMap) {
		Map<K,V> sortedMap =
					unsortedMap.entrySet().stream()
			       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			       .collect(Collectors.toMap(
			          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
	}
	
	private <K, V extends Comparable<? super V>> Map<K, V> sortByAscendingValue(
			Map<K, V> unsortedMap) {
	Map<K,V> sortedMap =
				unsortedMap.entrySet().stream()
		       .sorted(Map.Entry.comparingByValue())
		       .collect(Collectors.toMap(
		          Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	return sortedMap;
}
}
