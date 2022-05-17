package com.neosmart.punkapl.Model;

import java.util.ArrayList;

public class Method{
	private ArrayList<MashTemp> mash_temp;
	private Fermentation fermentation;
	private String twist;
	public Method(ArrayList<MashTemp> mash_temp, Fermentation fermentation, String twist) {
		this.mash_temp = mash_temp;
		this.fermentation = fermentation;
		this.twist = twist;
	}
	public Method() {
	}
	public ArrayList<MashTemp> getMash_temp() {
		return mash_temp;
	}
	public void setMash_temp(ArrayList<MashTemp> mash_temp) {
		this.mash_temp = mash_temp;
	}
	public Fermentation getFermentation() {
		return fermentation;
	}
	public void setFermentation(Fermentation fermentation) {
		this.fermentation = fermentation;
	}
	public String getTwist() {
		return twist;
	}
	public void setTwist(String twist) {
		this.twist = twist;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Method [mash_temp=");
		builder.append(mash_temp);
		builder.append(", fermentation=");
		builder.append(fermentation);
		builder.append(", twist=");
		builder.append(twist);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
