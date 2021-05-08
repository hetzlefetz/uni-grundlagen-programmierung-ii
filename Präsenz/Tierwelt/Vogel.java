
public class Vogel implements ITier {

	private String name;
	private String art;
	private int alter;
	private boolean isGefahr;
	private String laut;

	public Vogel(String art, int alter, boolean isGefahr, String laut, String name) {

		this.name = name;
		this.alter = alter;
		this.isGefahr = isGefahr;
		this.laut = laut;
		this.art = art;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Der Vogel ist ein(e):" + getArt() + ". Der Vogel " + getLaut() + " Der Vogel ist " + getAlter()
				+ "Jahre alt. Der Vogel lebt " + getLifestyle() + " Der Vogel heißt " + getName();
	}

	@Override
	public String getKlasse() {
		return "Vogel";
	}

	@Override
	public String getLifestyle() {

		return "Voliere";
	}

	@Override
	public String getArt() {
		return this.art;
	}

	@Override
	public int getAlter() {
		return this.alter;
	}

	@Override
	public String getLaut() {
		return this.laut;
	}

	@Override
	public boolean isGefahr() {
		return this.isGefahr;
	}

	@Override
	public void setArt(String s) {
		this.art = s;

	}

	@Override
	public void setAlter(int i) {
		this.alter = i;

	}

	@Override
	public void setLaut(String s) {
		this.laut = s;

	}

	@Override
	public void setIsGefahr(boolean b) {
		this.isGefahr = b;

	}

}
