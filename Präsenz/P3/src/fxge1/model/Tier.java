package fxge1.model;

import java.io.Serializable;

import fxge1.application.Utils;

public class Tier implements Comparable<Tier>, Serializable {

	public static enum TierKlasse {
		hund, vogel, grosskatze, fisch;
	}

	private TierKlasse klasse;
	private String art;
	private int alter;
	private String name;
	private String laut;
	private String lifeStyle;
	private boolean isGefahr;

	public Tier(TierKlasse klasse, String art, int alter, boolean isGefahr, String laut, String lifeStyle) {
		this.klasse = klasse;
		this.art = art;
		this.alter = pruefeAlter(alter);
		this.laut = laut;
		this.lifeStyle = lifeStyle;
		this.isGefahr = isGefahr;
	}

	public TierKlasse getKlasse() {
		return klasse;
	}

	public int getAlter() {
		return alter;
	}

	public boolean isGefahr() {
		return false;
	}

	public String getArt() {
		return this.art;
	}

	public String getLaut() {
		return laut;
	}

	public String getLifeStyle() {
		return lifeStyle;
	}

	public String getName() {
		return name;
	}

	public void addName(String name) {
		this.name = name;
	}

	private int pruefeAlter(int alter) {
		return fxge1.application.Utils.pruefeAlter(alter);
	}

	@Override
	public int compareTo(Tier o) {
		return this.getKlasse().compareTo(o.getKlasse());
	}

	@Override
	public String toString() {
		return "Der " + this.getArt() + " ist von der Klasse " + this.getKlasse() + " und hei�t " + this.name
				+ " und ist " + this.alter + " Jahre alt.\n  " + this.getLaut() + this.getLifeStyle();
	}
}
