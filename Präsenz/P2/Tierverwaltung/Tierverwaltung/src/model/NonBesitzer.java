package model;

import java.util.ArrayList;

public class NonBesitzer extends Person {	
	
	private ArrayList<Tier> tiere;
	
	public NonBesitzer(String vorname, String nachname, String geschlecht, int alter, String image, String email) {
		super(vorname, nachname, geschlecht, alter, image, email);
	}
	
	@Override
	public String toString() {
		StringBuilder sbTier = new StringBuilder();
		if(tiere != null) {
			for(Tier tier : tiere) {
				sbTier.append(tier);
				sbTier.append("\n");
			}
		}	
		return super.toString() + "\nhat kein Tier\n" + sbTier.toString();
	}
}
