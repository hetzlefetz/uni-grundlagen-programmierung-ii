package model;
import java.io.Serializable;

public class Fisch implements Tier, Serializable {
	
	private String art;
	private int alter;

	public Fisch(String art, int alter) {
		this.art = art;
		this.alter = pruefeAlter(alter);
	}
	
	@Override
	public String getKlasse() {	return "Fisch";	}
	
	@Override
	public int getAlter() {	return this.alter; }

	@Override
	public boolean isGefahr() { return false; }
	
	@Override
	public String getArt() { return this.art; }
	
	@Override
	public String getLaut() { return "Der Fisch blubbert. "; }

	@Override
	public String getLifeStyle() { return "Der Fisch lebt im Wasser. "; }
	
	@Override
	public String toString() {
		return "Der " + this.getArt() + " ist von der Klasse " + this.getKlasse() + " und ist ca. " + this.alter 
					+ " Jahre alt.\n  " + this.getLaut() + this.getLifeStyle();
	}
}
