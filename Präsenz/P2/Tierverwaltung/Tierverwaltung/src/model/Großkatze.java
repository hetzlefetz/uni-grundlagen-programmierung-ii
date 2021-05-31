package model;

import java.io.Serializable;

public class Großkatze implements Tier, Serializable {

	private String art;
	private int alter;

	public Großkatze(String art, int alter) {
		this.art = art;
		this.alter = pruefeAlter(alter);
	}

	@Override
	public String getKlasse() {
		return "Großkatze";
	}

	@Override
	public int getAlter() {
		return this.alter;
	}

	@Override
	public boolean isGefahr() {
		return true;
	};

	@Override
	public String getArt() {
		return this.art;
	}

	@Override
	public String getLaut() {
		return "Die Großkatze br�llt. ";
	}

	@Override
	public String getLifeStyle() {
		return "Die Großkatze lebt in der Wildnis. ";
	}

	@Override
	public String toString() {
		return "Der " + this.getArt() + " ist von der Klasse " + this.getKlasse() + " und ist ca. " + this.alter
				+ " Jahre alt.\n  " + this.getLaut() + this.getLifeStyle();
	}
}
