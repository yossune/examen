package com.neosmart.punkapl.Model;
public class Amount{
	
	private double value;
	private String unit;
	private Amount(double value, String unit) {
		this.value = value;
		this.unit = unit;
	}
	public Amount() {
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Amount [value=");
		builder.append(value);
		builder.append(", unit=");
		builder.append(unit);
		builder.append("]");
		return builder.toString();
	}
    
	
    
    
    
    
}
