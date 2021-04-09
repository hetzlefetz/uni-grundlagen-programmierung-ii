
public class PlzSorter extends CaseSwitchableSorter {

	public PlzSorter(boolean ignoreCase) {
		super(ignoreCase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Person o1, Person o2) {
		if (o1 == null && o2 == null) {
			return 0;
		}
		if (o1 == null && o2 != null) {
			return 1;
		}
		if (o2 == null && o1 != null) {
			return -1;
		}
		if (this.ignoreCase) {
			return o1.plz.compareToIgnoreCase(o2.plz);
		}
		return o1.plz.compareTo(o2.plz);
	}

}