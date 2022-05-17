package com.neosmart.punkapl.Model;


public class MashTemp{
	private Temp temp;
	private int duration;
	public MashTemp(Temp temp, int duration) {
		this.temp = temp;
		this.duration = duration;
	}
	public MashTemp() {
	}
	public Temp getTemp() {
		return temp;
	}
	public void setTemp(Temp temp) {
		this.temp = temp;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MashTemp [temp=");
		builder.append(temp);
		builder.append(", duration=");
		builder.append(duration);
		builder.append("]");
		return builder.toString();
	}
	
	
}
