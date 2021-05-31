package model;

import java.util.ArrayList;

public class Besitzer extends Person {	
	
	private ArrayList<Tier> tiere;
	
	public Besitzer(String vorname, String nachname, String geschlecht, int alter, String image, String email) {
		super(vorname, nachname, geschlecht, alter, image, email);
		
		tiere = new ArrayList<>();
	}
	
	public ArrayList<Tier> getTier() { return tiere; }
	public void addTier(Tier tier) { tiere.add(tier); };
	
	@Override
	public String toString() {
		StringBuilder sbTier = new StringBuilder();
		if(tiere != null) {
			for(Tier tier : tiere) {
				sbTier.append(tier);
				sbTier.append("\n");
			}
		}
		return super.toString() + "\nhat Tiere:\n" + sbTier.toString();
	}
}
