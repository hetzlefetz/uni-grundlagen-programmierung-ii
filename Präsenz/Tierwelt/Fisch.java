
public class Fisch extends Tier {

	public Fisch(String art, int alter, boolean isGefahr, String laut) {
		super(art, alter, isGefahr, laut);
	}
	
	@Override
	public String toString() {
		return "Fisch: " + super.toString();
	}
}
