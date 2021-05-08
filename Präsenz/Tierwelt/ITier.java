import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public interface ITier extends Serializable {

	public String getArt();

	public int getAlter();

	public String getLaut();

	public boolean isGefahr();

	public String getLifestyle();

	public void setArt(String s);

	public void setAlter(int i);

	public void setLaut(String s);

	public void setIsGefahr(boolean b);

	public String getKlasse();

	public default ArrayList<String> getAvailableTierklassen() {
		return new ArrayList<String>(Arrays.asList("Vogel", "Hund", "Großkatze", "Fisch"));
	}

	public default int pruefeAlter(int alter) {
		return Utils.pruefeAlter(alter);
	}

	@Override
	public String toString();
}
