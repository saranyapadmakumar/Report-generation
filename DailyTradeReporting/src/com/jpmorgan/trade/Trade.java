/**
 * 
 */
package com.jpmorgan.trade;

import java.time.LocalDate;

/**
 * @author ganes
 *
 */
public class Trade {
	private String instructionType;
	private String entityName;
	private double fxRate;
	private String currency;
	private LocalDate settlementDate;
	private LocalDate instructionDate;
	private long unit;
	private double pricePerUnit;
	private double totalAmount;
	
	public Trade(String entityName,String instructionType,double fxRate,String currency,LocalDate instructionDate,
			LocalDate settlementDate,long unit,double pricePerUnit,double totalAmount){
		this.instructionType = instructionType;
		this.entityName = entityName;
		this.fxRate = fxRate;
		this.currency = currency;
		this.settlementDate = settlementDate;
		this.instructionDate = instructionDate;
		this.unit = unit;
		this.pricePerUnit = pricePerUnit;
		this.totalAmount = totalAmount;
		
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public double getFxRate() {
		return fxRate;
	}

	public void setFxRate(double fxRate) {
		this.fxRate = fxRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public long getUnit() {
		return unit;
	}

	public void setUnit(long unit) { 
		this.unit = unit;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	

}
