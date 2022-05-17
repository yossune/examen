package com.neosmart.punkapl.Model;

import java.util.ArrayList;

public class Ingredients{
	private ArrayList<Malt> malt;
	private ArrayList<Hop> hops;
	private String yeast;
	public Ingredients(ArrayList<Malt> malt, ArrayList<Hop> hops, String yeast) {
		this.malt = malt;
		this.hops = hops;
		this.yeast = yeast;
	}
	public Ingredients() {
	}
	public ArrayList<Malt> getMalt() {
		return malt;
	}
	public void setMalt(ArrayList<Malt> malt) {
		this.malt = malt;
	}
	public ArrayList<Hop> getHops() {
		return hops;
	}
	public void setHops(ArrayList<Hop> hops) {
		this.hops = hops;
	}
	public String getYeast() {
		return yeast;
	}
	public void setYeast(String yeast) {
		this.yeast = yeast;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredients [malt=");
		builder.append(malt);
		builder.append(", hops=");
		builder.append(hops);
		builder.append(", yeast=");
		builder.append(yeast);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
