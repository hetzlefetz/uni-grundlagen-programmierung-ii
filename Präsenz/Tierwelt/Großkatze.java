
public class Großkatze extends Tier {

	public Großkatze(String art, int alter, boolean isGefahr, String laut) {
		super(art, alter, isGefahr, laut);
	}

	@Override
	public String toString() {
		return "Großkatze: " + super.toString();
	}
}
