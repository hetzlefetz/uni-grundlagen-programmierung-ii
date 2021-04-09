import java.util.Comparator;

public abstract class CaseSwitchableSorter implements Comparator<Person> {

	boolean ignoreCase = false;

	public CaseSwitchableSorter(boolean ignoreCase ) {
		this.ignoreCase = ignoreCase;
	}
}