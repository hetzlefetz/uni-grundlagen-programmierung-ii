package fxge1.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import javafx.collections.ObservableList;
import fxge1.model.Tier;

public class Utils<E> {

	// Pfad entsprechend anpassen!!
	static final String PATH = "C:\\Users\\knechtrootrecht\\source\\repos\\github.com\\hetzlefetz\\uni-grundlagen-programmierung-ii\\Präsenz\\P3";

	public static void printInfo(ArrayList<Tier> tiere) {

		// Iterator erstellen f�r ArrayList tiere
		Iterator<Tier> iter = tiere.iterator();
		while (iter.hasNext())
			System.out.println(iter.next().toString());

		System.out.println();
	}

	public static boolean checkEMail(String email) throws IOException {

		if ((email.length() < 3) || (!Character.isLetter(email.charAt(0)))
				|| (!Character.isLetter(email.charAt(email.length() - 1))) || (!email.contains("@")))
			throw new IOException("Email ung�ltig! ");

		return true;
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
			// Tier next = iter.next();
			//
			// boolean remove = false;
			// if(next.getKlasse().equals(objekt) && next instanceof Hund) {
			// remove = tiere.remove(next);
			// } else if(next.getKlasse().toLowerCase().equals(objekt) && next instanceof
			// Vogel) {
			// remove = tiere.remove(next);
			// } else if(next.getKlasse().toLowerCase().equals(objekt) && next instanceof
			// Fisch) {
			// remove = tiere.remove(next);
			// } else if(next.getKlasse().toLowerCase().equals(objekt) && next instanceof
			// grosskatze) {
			// remove = tiere.remove(next);
			// }
			//
			// if(remove) {
			// // L�cke wird nach dem L�schen geschlossen,
			// // Elemente verschieben sich also um einen Schritt nach vorne in der Liste
			// // Hinweis: Auch m�glich immer am Anfang der Liste, Index 0, wieder zu
			// beginnen,
			// // bei sehr gro�en Listen aber ineffektiv
			// i = iter.previousIndex();
			// iter = tiere.listIterator(i);
			//
			// // nur f�r die richtige Meldung
			// removed = true;
			// }
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
