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
	
	static final String PATH = "C:\\Users\\ahoen\\2021SoSe\\GPII\\workspace\\Resource";
	
	public static void printInfo(ArrayList<Tier> tiere) {
		for(Tier tier : tiere)
			System.out.println(tier.toString());
		
		System.out.println();
	}
	
	// bestimmte Tierklasse ausgeben
	public static void printTier(String klasse, ArrayList<Tier> tiere) {
		if(klasse.toLowerCase().equals("hund"))
			printTier(tiere, f -> f instanceof Hund);
		else if(klasse.toLowerCase().equals("vogel"))
			printTier(tiere, f -> f instanceof Vogel);
		else if(klasse.toLowerCase().equals("fisch"))
			printTier(tiere, f -> f instanceof Fisch);
		else if(klasse.toLowerCase().equals("großkatze"))
			printTier(tiere, f -> f instanceof Großkatze);
	}
	
	private static void printTier(ArrayList<Tier> tiere, Predicate<Tier> tester) {
		for (Tier tier : tiere) {
            if(tester.test(tier)) {
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
			} while(alter < 0);
		}
		return alter;
	}
	
	private static void checkAlter(int alter)
						throws IllegalArgumentException {
		if(alter < 0)
			throw new IllegalArgumentException("Alter nicht gültig! ");
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
	
	public static void insert(ArrayList<Tier> tiere) {
		int i = 0;
		BufferedReader br = null;
		try {
			String klasse = null;
			String art = null;
			int alter = 0;
			boolean haustier = false;
			String name = null;
			
			br = new BufferedReader(
						new InputStreamReader(System.in));
			
			System.out.println("\nBitte Daten für das Tier " + ++i + " eingeben!");
			
			// TODO: Daten für die Erstellung einen neues Tieres eingeben (br.readLine()) und 
			// zu der ArrayList tiere hinzufügen
			// Du brauchst alle oben deklarierten Variablen
			// Beachte, dass Haustiere zusätzlich einen Namen haben
			// Beachte, dass die spezielle Tierklasse ermittelt werden muss, um das entsprechende 
			// Tierobjekt zu erstellen
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// buffer schließen
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nDas Tier wurden erfolgreich erstellt!");
	}
	
	public static void removeArt(ArrayList<Tier> tiere, String art)  {
		int i = 0;
	
		// TODO: Tierobjekt nach der Art, z.B. Dackel des Tieres löschen
		// Eine Art ist nur einmal vorhanden		
		
		if(i < tiere.size())
			System.out.println("\nDas Tier wurden erfolgreich gelöscht!");
		else
			System.out.println("\nDas Tier konnte nicht gefunden werden!");
	}
	
	public static void removeKlasse(ArrayList<Tier> tiere, String klasse)  {
		int i = 0;
		boolean removed = false;
		
		String objekt = klasse.toLowerCase();
		
		// TODO: Alle Tierobjekte nach der Klasse, z.B. Vogel löschen
		// Wenn klasse z.B. vogel ist, dann muss auch abgefragt werden, 
		// ob ein aktuelles Tierobjekt aus dem Array eine entsprechende Instanz (Objekt) ist  
		
		if(removed)
			System.out.println("\nDie Tierklasse wurden erfolgreich gelöscht!");
		else
			System.out.println("\nDie Tierklasse konnte nicht gefunden werden!");
	}

	// ArrayList tiere nach Tierklasse sortieren
	public static void sort(ArrayList<Tier> tiere) {
		Collections.sort(tiere);
		
		// entsprechnder Lamda-Ausdruck
		//Collections.sort(tiere,(o1, o2) -> o1.getKlasse().compareTo(o2.getKlasse()));	     
	}
	
	// ArrayList in datei schreiben
	public static void schreibeDatenObjekt(ArrayList<Tier> tiere, String verz, String filename)  {

		if(tiere.isEmpty()) {
			System.out.println("Liste ist leer!");
			return;
		}
		
		File datei = new File(PATH + File.separatorChar + 
									verz + File.separatorChar + filename);
		
		// Verzeichnis physisch erstellen
		Utils.erstelleVerz(verz);
		
		// File physisch erstellen
		Utils.erstelleDatei(verz, filename);
		
		ObjectOutputStream oos = null;
		
		try {
			// TODO: Tierobjekte der ArrayList tiere in eine Datei achreiben
			
	   
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        // atream schließen
	        try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Daten erfolgreich geschrieben!");
	}
	
	// objekte aus Datei lesen
	public static ArrayList<Tier> leseDatenObjekt(String verz, String filename) {
		
		File datei = new File(PATH + File.separatorChar + 
											verz + File.separatorChar + filename);

		if(!datei.exists()) {
			System.out.println("\nDatei exisitiert nicht!!");
		    return null;
		}	
		
		// Eingabestrom oeffnen
        ObjectInputStream ois = null;
        
		try {
			
			// TODO: Tierobjekte aus der Datei lesen und in eine ArrayList achreiben und zurück geben
			
			    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        	// stream schließen
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		System.out.println("Daten erfolgreich gelesen!");

		return null;
	}
	
	public static boolean erstelleVerz(String verzeichnis) {
		
		File verz = new File(PATH + File.separatorChar + verzeichnis);
		
		if(verz.exists()) {
			System.out.println("Verzeichnis " + verzeichnis + " existiert bereits!");
			return false;
		}
		
		verz.mkdir();
		
		System.out.println("Verzeichnis "+ verzeichnis + " erfolgreich angelegt!");
		return true;
	}
		
	public static boolean erstelleDatei(String verz, String filename) {
		
		File file = new File(PATH + File.separatorChar + verz + 
											File.separatorChar + filename);
		
		if(file.exists()) {
			System.out.println("Datei " + filename + " existiert bereits!");
			return false;
		}
	
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Datei " + filename + " im Verzeichnis " + verz + 
														    " erfolgreich erstellt!");
		return true;
	}
}
