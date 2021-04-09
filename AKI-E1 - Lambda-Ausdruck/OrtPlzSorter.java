
public class OrtPlzSorter extends CaseSwitchableSorter {

	public OrtPlzSorter(boolean ignoreCase) {
		super(ignoreCase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1 == null && o2 == null) {
			return 0;
		}
		if(o1 == null && o2 != null) {
			return 1;
		}
		if(o2 == null && o1 != null) {
			return -1;
		}
		var tmp = 0;
		if (this.ignoreCase) {
			tmp = o1.ort.compareToIgnoreCase(o2.ort);
		} else {
			tmp = o1.ort.compareTo(o2.ort);
		}
		if (tmp == 0) {
			if (this.ignoreCase) {
				return o1.plz.compareToIgnoreCase(o2.plz);
			} else {
				return o1.plz.compareTo(o2.plz);
			}
		}
		return tmp;
	}

}