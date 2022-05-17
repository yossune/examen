package com.neosmart.punkapl.Model;


public class Malt{
	private String name;
	private Amount amount;
	public Malt(String name, Amount amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	public Malt() {
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Malt [name=");
		builder.append(name);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
