package com.neosmart.punkapl.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Cerveza{

    private int id;

    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private double abv;
    private double ibu;
    private double target_fg;
    private double target_og;
    private int ebc;
    private double srm;
    private double ph;
    private double attenuation_level;
    private Volume volume;
    private BoilVolume boil_volume;
    private Method method;
    private Ingredients ingredients;
    private ArrayList<String> food_pairing;
    private String brewers_tips;
    private String contributed_by;
    
    
	public Cerveza(int id, String name, String tagline, String first_brewed, String description, String image_url,
			double abv, double ibu, double target_fg, double target_og, int ebc, double srm, double ph, double attenuation_level,
			Volume volume, BoilVolume boil_volume, Method method, Ingredients ingredients,
			ArrayList<String> food_pairing, String brewers_tips, String contributed_by) {
		
		this.id = id;
		this.name = name;
		this.tagline = tagline;
		this.first_brewed = first_brewed;
		this.description = description;
		this.image_url = image_url;
		this.abv = abv;
		this.ibu = ibu;
		this.target_fg = target_fg;
		this.target_og = target_og;
		this.ebc = ebc;
		this.srm = srm;
		this.ph = ph;
		this.attenuation_level = attenuation_level;
		this.volume = volume;
		this.boil_volume = boil_volume;
		this.method = method;
		this.ingredients = ingredients;
		this.food_pairing = food_pairing;
		this.brewers_tips = brewers_tips;
		this.contributed_by = contributed_by;
	}


	public Cerveza() {
			}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTagline() {
		return tagline;
	}


	public void setTagline(String tagline) {
		this.tagline = tagline;
	}


	public String getFirst_brewed() {
		return first_brewed;
	}


	public void setFirst_brewed(String first_brewed) {
		this.first_brewed = first_brewed;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public double getAbv() {
		return abv;
	}


	public void setAbv(double abv) {
		this.abv = abv;
	}


	public double getIbu() {
		return ibu;
	}


	public void setIbu(double ibu) {
		this.ibu = ibu;
	}


	public double getTarget_fg() {
		return target_fg;
	}


	public void setTarget_fg(double target_fg) {
		this.target_fg = target_fg;
	}


	public double getTarget_og() {
		return target_og;
	}


	public void setTarget_og(double target_og) {
		this.target_og = target_og;
	}


	public int getEbc() {
		return ebc;
	}


	public void setEbc(int ebc) {
		this.ebc = ebc;
	}


	public double getSrm() {
		return srm;
	}


	public void setSrm(double srm) {
		this.srm = srm;
	}


	public double getPh() {
		return ph;
	}


	public void setPh(double ph) {
		this.ph = ph;
	}


	public double getAttenuation_level() {
		return attenuation_level;
	}


	public void setAttenuation_level(double attenuation_level) {
		this.attenuation_level = attenuation_level;
	}


	public Volume getVolume() {
		return volume;
	}


	public void setVolume(Volume volume) {
		this.volume = volume;
	}


	public BoilVolume getBoil_volume() {
		return boil_volume;
	}


	public void setBoil_volume(BoilVolume boil_volume) {
		this.boil_volume = boil_volume;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}


	public Ingredients getIngredients() {
		return ingredients;
	}


	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}


	public ArrayList<String> getFood_pairing() {
		return food_pairing;
	}


	public void setFood_pairing(ArrayList<String> food_pairing) {
		this.food_pairing = food_pairing;
	}


	public String getBrewers_tips() {
		return brewers_tips;
	}


	public void setBrewers_tips(String brewers_tips) {
		this.brewers_tips = brewers_tips;
	}


	public String getContributed_by() {
		return contributed_by;
	}


	public void setContributed_by(String contributed_by) {
		this.contributed_by = contributed_by;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cerveza [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tagline=");
		builder.append(tagline);
		builder.append(", first_brewed=");
		builder.append(first_brewed);
		builder.append(", description=");
		builder.append(description);
		builder.append(", image_url=");
		builder.append(image_url);
		builder.append(", abv=");
		builder.append(abv);
		builder.append(", ibu=");
		builder.append(ibu);
		builder.append(", target_fg=");
		builder.append(target_fg);
		builder.append(", target_og=");
		builder.append(target_og);
		builder.append(", ebc=");
		builder.append(ebc);
		builder.append(", srm=");
		builder.append(srm);
		builder.append(", ph=");
		builder.append(ph);
		builder.append(", attenuation_level=");
		builder.append(attenuation_level);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", boil_volume=");
		builder.append(boil_volume);
		builder.append(", method=");
		builder.append(method);
		builder.append(", ingredients=");
		builder.append(ingredients);
		builder.append(", food_pairing=");
		builder.append(food_pairing);
		builder.append(", brewers_tips=");
		builder.append(brewers_tips);
		builder.append(", contributed_by=");
		builder.append(contributed_by);
		builder.append("]");
		return builder.toString();
	}
    
    
}
