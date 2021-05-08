import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class Utils {

	static final String PATH = "./";

	public static void printInfo(ArrayList<ITier> tiere) {
		for (var tier : tiere)
			System.out.println(tier.toString());

		System.out.println();
	}

	// bestimmte Tierklasse ausgeben
	public static void printTier(String klasse, ArrayList<ITier> tiere) {
		if (klasse.toLowerCase().equals("hund"))
			printTier(tiere, f -> f instanceof Hund);
		else if (klasse.toLowerCase().equals("vogel"))
			printTier(tiere, f -> f instanceof Vogel);
		else if (klasse.toLowerCase().equals("fisch"))
			printTier(tiere, f -> f instanceof Fisch);
		else if (klasse.toLowerCase().equals("großkatze"))
			printTier(tiere, f -> f instanceof Großkatze);
	}

	private static void printTier(ArrayList<ITier> tiere, Predicate<ITier> tester) {
		for (var tier : tiere) {
			if (tester.test(tier)) {
				System.out.println(tier);
			}
		}
	}

	public static int pruefeAlter(int alter) {
		try {
			checkAlter(alter);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			do {
				alter = eingabeAlter();
			} while (alter < 0);
		}
		return alter;
	}

	private static void checkAlter(int alter) throws IllegalArgumentException {
		if (alter < 0)
			throw new IllegalArgumentException("Alter nicht g�ltig! ");
	}

	public static int eingabeAlter() {
		Scanner scan = new Scanner(System.in);
		int alter = -1;

		try {
			alter = scan.nextInt();
			checkAlter(alter);
		} catch (InputMismatchException e) {
			System.out.println("Eingabe nicht gültig! Bitte eine Zahl eingeben: ");
			return alter;
		} catch (IllegalArgumentException e) {
			System.out.println("Alter nicht gültig! Bitte neues Alter eingeben: ");
			return alter;
		}
		return alter;
	}

	public static void insert(ArrayList<ITier> tiere) {
		int i = 0;
		BufferedReader br = null;
		try {

			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nBitte Daten für das Tier " + ++i + " eingeben!");
			switch (tiere.get(i - 1).getKlasse()) {
				case "Hund": {
					System.out.println("Name:");
					var name = br.readLine();
					System.out.println("Art:");
					var art = br.readLine();
					System.out.println("Alter:");
					var alt = br.readLine();
					System.out.println("Gefährlich:");
					var gef = br.readLine();
					System.out.println("Laut:");
					var laut = br.readLine();

					((Hund) tiere.get(i - 1)).setName(name);
					tiere.get(i - 1).setAlter(Integer.parseInt(alt));
					tiere.get(i - 1).setArt(art);
					tiere.get(i - 1).setIsGefahr(Boolean.parseBoolean(gef));
					tiere.get(i - 1).setLaut(laut);
					break;
				}

				case "Vogel": {
					System.out.println("Name:");
					var name = br.readLine();
					System.out.println("Art:");
					var art = br.readLine();
					System.out.println("Alter:");
					var alt = br.readLine();
					System.out.println("Gefährlich:");
					var gef = br.readLine();
					System.out.println("Laut:");
					var laut = br.readLine();

					((Vogel) tiere.get(i - 1)).setName(name);
					tiere.get(i - 1).setAlter(Integer.parseInt(alt));
					tiere.get(i - 1).setArt(art);
					tiere.get(i - 1).setIsGefahr(Boolean.parseBoolean(gef));
					tiere.get(i - 1).setLaut(laut);
					break;
				}
				default: {
					System.out.println("Art:");
					var art = br.readLine();
					System.out.println("Alter:");
					var alt = br.readLine();
					System.out.println("Gefährlich:");
					var gef = br.readLine();
					System.out.println("Laut:");
					var laut = br.readLine();

					tiere.get(i - 1).setAlter(Integer.parseInt(alt));
					tiere.get(i - 1).setArt(art);
					tiere.get(i - 1).setIsGefahr(Boolean.parseBoolean(gef));
					tiere.get(i - 1).setLaut(laut);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\nDas Tier wurden erfolgreich erstellt!");
	}

	public static void removeArt(ArrayList<ITier> tiere, String art) {
		boolean removed = false;

		for (int i = tiere.size() - 1; i >= 0; i--) {
			if (tiere.get(i).getArt().toLowerCase() == art) {
				tiere.remove(i);
				removed = true;
			}
		}

		if (removed)
			System.out.println("\nDas Tier wurden erfolgreich gelöscht!");
		else
			System.out.println("\nDas Tier konnte nicht gefunden werden!");
	}

	public static void removeKlasse(ArrayList<ITier> tiere, String klasse) {

		boolean removed = false;

		String objekt = klasse.toLowerCase();

		for (int i = tiere.size() - 1; i >= 0; i--) {
			if (tiere.get(i).getKlasse().toLowerCase() == objekt) {
				tiere.remove(i);
				removed = true;
			}
		}

		if (removed)
			System.out.println("\nDie Tierklasse wurden erfolgreich gel�scht!");
		else
			System.out.println("\nDie Tierklasse konnte nicht gefunden werden!");

	}

	// ArrayList tiere nach Tierklasse sortieren
	public static void sort(ArrayList<ITier> tiere) {
		// Collections.sort(tiere);

		// entsprechnder Lamda-Ausdruck
		// Collections.sort(tiere,(o1, o2) -> o1.getKlasse().compareTo(o2.getKlasse()));
	}

	// ArrayList in datei schreiben
	public static void schreibeDatenObjekt(ArrayList<ITier> tiere, String verz, String filename) {

		if (tiere.isEmpty()) {
			System.out.println("Liste ist leer!");
			return;
		}

		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		// Verzeichnis physisch erstellen
		Utils.erstelleVerz(verz);

		// File physisch erstellen
		Utils.erstelleDatei(verz, filename);

		ObjectOutputStream oos = null;

		try (var fs = new FileOutputStream(datei)) {

			oos = new ObjectOutputStream(fs);
			oos.writeObject(tiere);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Daten erfolgreich geschrieben!");
	}

	// objekte aus Datei lesen
	public static ArrayList<ITier> leseDatenObjekt(String verz, String filename) {

		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		if (!datei.exists()) {
			System.out.println("\nDatei exisitiert nicht!!");
			return null;
		}

		// Eingabestrom oeffnen
		ObjectInputStream ois = null;

		try (var fs = new FileInputStream(datei)) {

			ois = new ObjectInputStream(fs);
			return (ArrayList<ITier>) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Daten erfolgreich gelesen!");

		return null;
	}

	public static boolean erstelleVerz(String verzeichnis) {

		File verz = new File(PATH + File.separatorChar + verzeichnis);

		if (verz.exists()) {
			System.out.println("Verzeichnis " + verzeichnis + " existiert bereits!");
			return false;
		}

		verz.mkdir();

		System.out.println("Verzeichnis " + verzeichnis + " erfolgreich angelegt!");
		return true;
	}

	public static boolean erstelleDatei(String verz, String filename) {

		File file = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		if (file.exists()) {
			System.out.println("Datei " + filename + " existiert bereits!");
			return false;
		}

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Datei " + filename + " im Verzeichnis " + verz + " erfolgreich erstellt!");
		return true;
	}
}
