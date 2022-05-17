
package com.neosmart.punkapl.Model;

public class Fermentation{
	private Temp temp;

	public Fermentation(Temp temp) {
		this.temp = temp;
	}

	public Fermentation() {
	}

	public Temp getTemp() {
		return temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fermentation [temp=");
		builder.append(temp);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

