/**
 * 
 */
package com.jpmorgan.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author ganes
 *
 */
public class TradeUtils {
	
	public double calculateUSDAmount(double rate,long units,double price){
		return price * rate* units;
	}
	
	public LocalDate checkWorkingDay(String currency,LocalDate settlementDate){
		
		LocalDate  sDate = settlementDate;
		String dayOfWeek = sDate.getDayOfWeek().toString();
		if((currency.equalsIgnoreCase("AED")) || (currency.equalsIgnoreCase("SAR"))){
			switch(dayOfWeek.toUpperCase()){
				case "FRIDAY" : sDate = sDate.plusDays(2);
								break;
				case "SATURDAY" : sDate = sDate.plusDays(1);
									break; 
								
			}
		}else{
				switch(dayOfWeek.toUpperCase()){
				case "SATURDAY" : sDate = sDate.plusDays(2);
									break; 
				case "SUNDAY" : sDate = sDate.plusDays(1);
				break;					
		
			}
		}
		
		return sDate;
	}

	public LocalDate getDate(String dateString) throws DateTimeParseException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		return date;
	}

}
