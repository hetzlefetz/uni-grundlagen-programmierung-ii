import java.util.ArrayList;

public class Telefonliste {

	private ArrayList<TelefonEintrag> backingList = new ArrayList<TelefonEintrag>();

	public void clear() {
		backingList.clear();

	}

	public void addEntry(String name, String number) {
		backingList.add(new TelefonEintrag(name, number));

	}

	public boolean modifyEntry(String oldName, String oldNumber, String newName, String newNumber) {

		var index = backingList.indexOf(new TelefonEintrag(oldName, oldNumber));
		if (index < 0) {
			return false;
		}
		backingList.set(index, new TelefonEintrag(newName, newNumber));
		// TODO Auto-generated method stub
		return true;
	}

	public int size() {
		return backingList.size();
	}

	public String searchNameByNumber(String number) {

		var found = backingList.stream().filter(x -> x.getNumber() == number).findFirst();
		if (found.isPresent()) {
			return found.get().toString();
		}
		return "";
	}

	public String searchByName(String name) {
		var found = backingList.stream().filter(x -> x.getName() == name).findFirst();
		if (found.isPresent()) {
			return found.get().toString();
		}
		return "";

	}

	public void removeEntry(String name, String number) {
		backingList.remove(new TelefonEintrag(name, number));

	}
}
