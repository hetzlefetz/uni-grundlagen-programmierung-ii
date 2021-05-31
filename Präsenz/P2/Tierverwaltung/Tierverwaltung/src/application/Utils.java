package application;

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
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import model.Fisch;
import model.Großkatze;
import model.Hund;
import model.Person;
import model.Tier;
import model.Vogel;

public class Utils<E> {

	// Pfad entsprechend anpassen!!
	static final String PATH = "C:\\Users\\knechtrootrecht\\tmp";

	public static void printInfo(ArrayList<Tier> tiere) {

		// Iterator erstellen f�r ArrayList tiere
		Iterator<Tier> iter = tiere.iterator();
		while (iter.hasNext())
			System.out.println(iter.next().toString());

		System.out.println();
	}

	// bestimmte Tierklasse ausgeben
	public static void printTier(ArrayList<Tier> tiere, String klasse) {
		if (klasse.toLowerCase().equals("hund"))
			printTier(tiere, f -> f instanceof Hund);
		else if (klasse.toLowerCase().equals("vogel"))
			printTier(tiere, f -> f instanceof Vogel);
		else if (klasse.toLowerCase().equals("fisch"))
			printTier(tiere, f -> f instanceof Fisch);
		else if (klasse.toLowerCase().equals("Großkatze"))
			printTier(tiere, f -> f instanceof Großkatze);
	}

	public static boolean checkEMail(String email) throws IOException {

		if ((email.length() < 3) || (!Character.isLetter(email.charAt(0)))
				|| (!Character.isLetter(email.charAt(email.length() - 1))) || (!email.contains("@")))
			throw new IOException("Email ung�ltig! ");

		return true;
	}

	public static void printAlter(ArrayList<Tier> tiere, int maxAlter) {
		printTier(tiere, f -> f.getAlter() > maxAlter);
	}

	private static void printTier(ArrayList<Tier> tiere, Predicate<Tier> tester) {
		for (Tier tier : tiere) {
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
			System.out.println("Eingabe nicht g�ltig! Bitte eine Zahl eingeben: ");
			return alter;
		} catch (IllegalArgumentException e) {
			System.out.println("Alter nicht g�ltig! Bitte neues Alter eingeben: ");
			return alter;
		}
		return alter;
	}

	public static void insert(ArrayList<Tier> tiere) {
		int i = 0;
		BufferedReader br = null;
		try {
			String klasse = null;
			String art = null;
			int alter = 0;
			boolean haustier = false;
			String name = null;

			// einlesen von daten, umwandlung bytes nach char und in buffer
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\nBitte Daten f�r das Tier " + ++i + " eingeben!");

			System.out.print("Was f�r ein Tier ist es? (Hund/Vogel/Fisch/Gro�katze) ");
			klasse = br.readLine();

			System.out.print("Bitte gebe die Art des Tieres ein: ");
			art = br.readLine();

			System.out.print("Bitte gebe das Alter ein: ");
			alter = Integer.parseInt(br.readLine());

			System.out.print("Ist das Tier ein Haustier (true/false)? ");
			haustier = Boolean.parseBoolean(br.readLine());

			if (haustier) {
				System.out.print("Bitte gebe den Namen des Tieres ein: ");
				name = br.readLine();
			}

			switch (klasse.toLowerCase()) {
				case "hund":
					tiere.add(new Hund(art, alter, name));
					break;
				case "vogel":
					tiere.add(new Vogel(art, alter, name));
					break;
				case "fisch":
					tiere.add(new Fisch(art, alter));
					break;
				case "gro�katze":
					tiere.add(new Großkatze(art, alter));
					break;
				default:
					System.out.println("Es wurde kein neues Tier erstellt");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// buffer schlie�en
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nDas Tier wurden erfolgreich erstellt!");
	}

	public static void removeArt(ArrayList<Tier> tiere, String art) {
		int i = 0;
		boolean removed = false;

		while (i < tiere.size()) {
			if (tiere.get(i).getArt().toLowerCase().equals(art.toLowerCase())) {
				tiere.remove(tiere.get(i));
				removed = true;
				break;
			}
			i++;
		}

		// Hinweis: kleine �nderung
		if (removed)
			System.out.println("\nDas Tier " + art + " wurden erfolgreich gel�scht!");
		else
			System.out.println("\nDas Tier " + art + " konnte nicht gefunden werden!");
	}

	public static void removeKlasse(ArrayList<Tier> tiere, String klasse) {
		int i = 0;
		boolean removed = false;

		String objekt = klasse.toLowerCase();

		// Abgeleitetes Interface vom Interface Iterator
		ListIterator<Tier> iter = tiere.listIterator();
		while (iter.hasNext()) {
			Tier next = iter.next();

			boolean remove = false;
			if (next.getKlasse().toLowerCase().equals(objekt) && next instanceof Hund) {
				remove = tiere.remove(next);
			} else if (next.getKlasse().toLowerCase().equals(objekt) && next instanceof Vogel) {
				remove = tiere.remove(next);
			} else if (next.getKlasse().toLowerCase().equals(objekt) && next instanceof Fisch) {
				remove = tiere.remove(next);
			} else if (next.getKlasse().toLowerCase().equals(objekt) && next instanceof Großkatze) {
				remove = tiere.remove(next);
			}

			if (remove) {
				// L�cke wird nach dem L�schen geschlossen,
				// Elemente verschieben sich also um einen Schritt nach vorne in der Liste
				// Hinweis: Auch m�glich immer am Anfang der Liste, Index 0, wieder zu beginnen,
				// bei sehr gro�en Listen aber ineffektiv
				i = iter.previousIndex();
				iter = tiere.listIterator(i);

				// nur f�r die richtige Meldung
				removed = true;
			}
		}
		if (removed)
			System.out.println("\nDie Tierklasse " + klasse + " wurden erfolgreich gel�scht!");
		else
			System.out.println("\nDie Tierklasse " + klasse + " konnte nicht gefunden werden!");
	}

	public static void sort(ArrayList<Tier> tiere) {
		System.out.println("Sortierte Liste: ");
		Collections.sort(tiere);

		// Lambda - Ausdruck
		// Collections.sort(tiere,(o1, o2) -> o1.getKlasse().compareTo(o2.getKlasse()));
	}

	public static <E> ArrayList<E> copyList(ObservableList<E> all) {
		ArrayList<E> liste = new ArrayList<>();
		if (all != null)
			for (E t : all)
				liste.add(t);

		return liste;
	}

	// ArrayList in datei schreiben
	public static <E> void schreibeDatenObjekt(ArrayList<E> liste, String verz, String filename) {

		if (liste.isEmpty()) {
			System.out.println("Liste ist leer!");
			return;
		}

		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		System.out.println(datei.toString());

		// Verzeichnis physisch erstellen
		Utils.erstelleVerz(verz);

		// File physisch erstellen
		Utils.erstelleDatei(verz, filename);

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(datei));

			oos.writeObject(liste);

			// stream leeren und weitergeben
			oos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// atream schlie�en
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nDaten erfolgreich geschrieben!");
	}

	// objekte aus Datei lesen
	public static <E> ArrayList<E> leseDatenObjekt(String verz, String filename) {

		File datei = new File(PATH + File.separatorChar + verz + File.separatorChar + filename);

		if (!datei.exists()) {
			System.out.println("\nDatei exisitiert nicht!!");
			return null;
		}

		ArrayList<E> objektList = new ArrayList<>();

		// Eingabestrom oeffnen
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(datei));

			objektList = (ArrayList<E>) ois.readObject();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// stream schlie�en
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Daten erfolgreich gelesen!");

		return objektList;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Datei " + filename + " im Verzeichnis " + verz + " erfolgreich erstellt!");
		return true;
	}
}
