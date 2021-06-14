package fxge1.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import fxge1.application.Utils;

public class Person implements Comparable<Person>, Serializable {

	private static int id = 0;

	public static enum PersonTyp {
		besitzer, nonbesiter;
	}

	private String vorname;
	private String nachname;
	private int alter;
	private String geschlecht;
	private String image;
	private ArrayList<String> emails;
	private String email;
	private PersonTyp personTyp;
	private ArrayList<Tier> tiere;

	public Person(PersonTyp typ, String vorname, String nachname, String geschlecht, int alter, String image,
			String email) {

		emails = new ArrayList<>();

		this.personTyp = typ;
		this.vorname = vorname;
		this.nachname = nachname;
		this.image = image;
		this.geschlecht = geschlecht;
		this.personTyp = typ;
		this.alter = pruefeAlter(alter);
		if (pruefeEmail(email)) {
			this.email = email;
			this.emails.add(email);
		}
		tiere = new ArrayList<>();
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getImage() {
		return image;
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public String getEmail() {
		return email;
	}

	public int getAlter() {
		return alter;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public String getPersonTyp() {
		return personTyp.toString();
	}

	public static int getId() {
		return ++id;
	}

	public void addEmail(String email) {
		if (pruefeEmail(email)) {
			this.email = email;
			emails.add(email);
		}
	}

	public ArrayList<Tier> getTiere() {
		return tiere;
	}

	public void addTier(Tier tier) {
		tiere.add(tier);
	};

	public void setAlter(int alter) {
		this.alter = pruefeAlter(alter);
	}

	@Override
	public String toString() {
		StringBuilder sbEmail = new StringBuilder();
		if (emails != null) {
			for (String mail : emails) {
				sbEmail.append(mail);
				sbEmail.append("\n");
			}
		}
		return "Vorname " + this.vorname + "\nNachname " + this.nachname + "\nGeschlecht " + this.geschlecht
				+ "\nAlter " + this.alter + "\nEmail:\n" + sbEmail.toString();
	}

	private int pruefeAlter(int alter) {
		return Utils.pruefeAlter(alter);
	}

	private boolean pruefeEmail(String email) {
		try {
			Utils.checkEMail(email);
		} catch (IOException e) {
			System.out.println("Email ung�ltig");
		}
		return true;
	}

	@Override
	public int compareTo(Person o) {
		return this.getVorname().compareTo(o.getVorname());
	}
}
