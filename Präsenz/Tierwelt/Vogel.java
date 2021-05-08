
public class Vogel extends Tier {
	
	private String name;

	public Vogel(String art, int alter, boolean isGefahr, String laut, String name) {
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
		return "Vogel: " + super.toString() + " und heiﬂt " + this.name;
	}
}
