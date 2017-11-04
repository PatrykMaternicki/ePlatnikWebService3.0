package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo;

public class Bonus {
	private String typeBonus;
	private Double value;
	private Double percentBonus;
	private String itemBonus;
	public String getTypeBonus() {
		return typeBonus;
	}
	public void setTypeBonus(String typeBonus) {
		this.typeBonus = typeBonus;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Double getPercentBonus() {
		return percentBonus;
	}
	public void setPercentBonus(Double percentBonus) {
		this.percentBonus = percentBonus;
	}
	public String getItemBonus() {
		return itemBonus;
	}
	public void setItemBonus(String itemBonus) {
		this.itemBonus = itemBonus;
	}
	
}
