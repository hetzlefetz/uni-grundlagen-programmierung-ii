package model;
import java.io.Serializable;

public class Vogel implements Tier, Serializable {
	
	private String art;
	private int alter;
	private String name;

	public Vogel(String art, int alter, String name) {
		this.art = art;
		this.name = name;
		this.alter = pruefeAlter(alter);
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public String getKlasse() {	return "Vogel";	}
	
	@Override
	public int getAlter() {	return this.alter; }

	@Override
	public boolean isGefahr() { return false; };
	
	@Override
	public String getArt() {  return this.art; }
	
	@Override
	public String getLaut() { return "Der Vogel piept. "; }

	@Override
	public String getLifeStyle() { return "Der Vogel lebt in einer Voliere. "; }
	
	
	@Override
	public String toString() {
		return "Der " + this.getArt() + " ist von der Klasse " + this.getKlasse()  
		+ " und heiﬂt " + this.name + " und ist " + this.alter + " Jahre alt.\n  "
		+ this.getLaut() + this.getLifeStyle();
	}





}
