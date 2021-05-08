
public class Fisch implements ITier {

	private String art;
	private int alter;
	private boolean isGefahr;
	private String laut;

	public Fisch(String art, int alter, boolean isGefahr, String laut) {
		this.alter = alter;
		this.isGefahr = isGefahr;
		this.laut = laut;
		this.art = art;
	}

	@Override
	public String toString() {
		return "Der Fisch ist ein(e):" + getArt() + ". Der Fisch " + getLaut() + " Der Fisch ist " + getAlter()
				+ "Jahre alt. Der Fisch lebt " + getLifestyle();
	}

	@Override
	public String getKlasse() {

		return "Fisch";
	}

	@Override
	public String getLifestyle() {

		return "Unter Wasser";
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
