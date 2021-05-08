
public class Hund extends Tier {
	
	private String name;

	public Hund(String art, int alter, boolean isGefahr, String laut, String name) {
		super(art, alter, isGefahr, laut);
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Hund: " + super.toString() + " und heiﬂt " + this.name;
	}
}
