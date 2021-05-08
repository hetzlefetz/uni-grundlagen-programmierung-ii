import java.util.InputMismatchException;
import java.util.Scanner;

public class Tier {
	
	private String art;
	private int alter;
	private boolean isGefahr;
	private String laut;

	public Tier(String art, int alter, boolean isGefahr, String laut) {
		this.art = art;
		this.isGefahr = isGefahr;
		this.laut = laut;
		
		try {
			checkAlter(alter);  
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
			do {
				alter = eingabeAlter();
			} while(alter < 0);
		}
		
		System.out.println("Alles ok!");
		this.alter = alter;
	}
	
	public void checkAlter(int alter) 
								throws IllegalArgumentException {
		if(alter < 0)
			throw new IllegalArgumentException("Alter nicht gültig! Bitte neues Alter eingeben: ");
	
	}
	
	public int eingabeAlter() {
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

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public boolean isGefahr() {
		return isGefahr;
	}

	public void setGefahr(boolean isGefahr) {
		this.isGefahr = isGefahr;
	}

	public String getLaut() {
		return laut;
	}

	public void setLaut(String laut) {
		this.laut = laut;
	}
	
	@Override
	public String toString() {
		return "Tier: " + this.art + " ist " + this.alter + " Jahre alt und " + this.laut;
	}
}
