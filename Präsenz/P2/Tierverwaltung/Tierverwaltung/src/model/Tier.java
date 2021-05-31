package model;

import java.util.ArrayList;
import application.Utils;

public interface Tier extends Comparable<Tier> {
	
	String getArt();
	int getAlter();
	boolean isGefahr();
	String getLaut();
	String getKlasse();
	String getLifeStyle();
	
	default ArrayList<String> getavailableTierKlassen() {
		ArrayList<String> klassen = new ArrayList<>();
		klassen.add("Hund");
		klassen.add("Vogel");
		klassen.add("Groﬂkatze");
		klassen.add("Fisch");
		
		return klassen;
	}
	
	default int pruefeAlter(int alter) {
		return Utils.pruefeAlter(alter);
	}
	
	@Override
    default int compareTo(Tier o) {
		return this.getKlasse().compareTo(o.getKlasse());
    }
}
