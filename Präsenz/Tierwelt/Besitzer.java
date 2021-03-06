import java.util.ArrayList;

public class Besitzer extends Person {

	private ArrayList<ITier> tiere;

	public Besitzer(String vorname, String nachname, int alter, String geschlecht) {
		super(vorname, nachname, alter, geschlecht);

		tiere = new ArrayList<>();
	}

	public ArrayList<ITier> getTier() {
		return tiere;
	}

	public void addTier(ITier tier) {
		tiere.add(tier);
	}

	public boolean hasTier() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " besitzt das Tier/ die Tiere " + " " + tiere.toString();
	}
}
