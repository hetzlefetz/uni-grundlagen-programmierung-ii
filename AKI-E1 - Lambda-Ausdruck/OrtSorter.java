
public class OrtSorter extends CaseSwitchableSorter {

	public OrtSorter(boolean ignoreCase) {
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
			return o1.ort.compareToIgnoreCase(o2.ort);
		}
		return o1.ort.compareTo(o2.ort);
	}

}