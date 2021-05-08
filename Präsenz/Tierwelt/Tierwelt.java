import java.util.ArrayList;
import java.util.Scanner;

public class Tierwelt {

	final static String filename = "Tiere.txt";
	final static String verz = "Projekt";
	private ArrayList<ITier> _tiere = new ArrayList<ITier>();

	public Tierwelt() {

		_tiere.add(new Hund("Dackel", 212, true, "woof", "Hundi"));
		_tiere.add(new Hund("Dackel", 2, false, "woof", "idnuH"));
		_tiere.add(new Vogel("Taube", 1, false, "gurr", "Komischer Vogel"));
		_tiere.add(new Großkatze("Tiger", 3, true, "brüll"));
		_tiere.add(new Fisch("Backfisch", 1, false, "blub"));
		var Besitzer = new Besitzer("foo", "bar", 23, "123");
		Besitzer.addTier(_tiere.get(0));
		Besitzer.addTier(_tiere.get(1));
		System.out.println(Besitzer);
		run();
	}

	public void run() {
		Utils.printInfo(_tiere);

		insert();
		Utils.printInfo(_tiere);

		sort();
		Utils.printInfo(_tiere);

		printTier("Großkatze");

		remove("klasse", "Hund");
		Utils.printInfo(_tiere);

		remove("art", "Jagdhund");
		Utils.printInfo(_tiere);

		writeTiereToFile();
		System.out.println();

		ArrayList<ITier> tierList = new ArrayList<>();
		tierList = readTiereFromFile();
		Utils.printInfo(tierList);

	}

	// schreiben Tiere in Datei
	public void writeTiereToFile() {
		Utils.schreibeDatenObjekt(_tiere, verz, filename);
		System.out.println();
	}

	// lesen Tiere aus Datei
	public ArrayList<ITier> readTiereFromFile() {
		ArrayList<ITier> tiere = Utils.leseDatenObjekt(verz, filename);
		return tiere;
	}

	// Tier hinzuf�gen
	public void insert() {
		Utils.insert(_tiere);
	}

	// Tier nach Art oder Klasse l�schen
	public void remove(String kriterium) {
		System.out.println("Nach welchem Kriterium soll ein Tier bzw. Tiere entfernt werden (Art/Klasse)");
		Scanner scan = new Scanner(System.in);
		if (scan.equals("Art"))
			// tier nach art l�schen
			Utils.removeArt(_tiere, kriterium);
		else
			// tier nach klasse l�schen
			Utils.removeKlasse(_tiere, kriterium);
	}

	// Tier nach Art oder Klasse l�schen
	public void remove(String kriterium, String value) {
		System.out.println("Nach welchem Kriterium soll ein Tier bzw. Tiere entfernt werden (Art/Klasse)");
		Scanner scan = new Scanner(System.in);
		if (kriterium == "Art")
			// tier nach art l�schen
			Utils.removeArt(_tiere, value);
		else
			// tier nach klasse l�schen
			Utils.removeKlasse(_tiere, value);
	}

	// Tier nach Klasse sortieren
	public void sort() {
		Utils.sort(_tiere);
	}

	// gibt Informtionen von einem bestimmten Tier aus
	public void printTier(String tier) {
		Utils.printTier(tier, _tiere);
	}

	public static void main(String[] args) {
		new Tierwelt();
	}
}
