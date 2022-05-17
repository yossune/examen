package com.neosmart.punkapl.Model;


public class Hop{
	private String name;
	private Amount amount;
	private String add;
	private String attribute;
	public Hop(String name, Amount amount, String add, String attribute) {
		this.name = name;
		this.amount = amount;
		this.add = add;
		this.attribute = attribute;
	}
	public Hop() {
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
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hop [name=");
		builder.append(name);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", add=");
		builder.append(add);
		builder.append(", attribute=");
		builder.append(attribute);
		builder.append("]");
		return builder.toString();
	}
	
	
}
