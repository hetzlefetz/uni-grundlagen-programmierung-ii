package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personen {

	private static ArrayList<Person> defaultList;
	private static ObservableList<Person> observableList;

	public static void addDefault(Person person) {
		observableList.add(person);
	}

	public static ObservableList<Person> getAllPersonen() {
		return observableList;
	}

	public static void setList(ArrayList<Person> liste) {
		observableList = FXCollections.observableArrayList(liste);
	}

	public static ObservableList<Person> getDefaultList() {
		defaultList = new ArrayList<>();

		// Person 1
		Besitzer albert = new Besitzer("Albert", "Einstein", "m", 49, "einstein.jpeg",
				"albert.einstein@beuth-hochschule.de");

		albert.addEmail("albert.einstein@beuth-hochschule.de");
		albert.addTier(new Hund("Jagdhund", 4, "Flo"));
		albert.addTier(new Vogel("Papagei", 5, "Lili"));

		// Person
		Besitzer vater = new Besitzer("Vater", "Einstein", "m", 83, "einstein.jpeg",
				"vater.einstein@beuth-hochschule.de");
		vater.addTier(new Hund("Dackel", 3, "Freddy"));

		NonBesitzer mutter = new NonBesitzer("Mutter", "Einstein", "w", 79, "einstein.jpeg",
				"mutter.einstein@beuth-hochschule.de");

		Besitzer schwester1 = new Besitzer("Kleine Schwester", "Einstein", "w", 34, "einstein.jpeg",
				"schwester1.einstein@beuth-hochschule.de");

		schwester1.addTier(new Vogel("Sittich", 12, "Hans"));

		NonBesitzer bruder3 = new NonBesitzer("Kleiner Bruder", "Einstein", "m", 25, "einstein.jpeg",
				"bruder3.einstein@beuth-hochschule.de");
		bruder3.addEmail("bruder3.einstein@beuth-hochschule.de");
		bruder3.addEmail("bruder3.einstein@beuth-hochschule.de");

		NonBesitzer schwester2 = new NonBesitzer("Gro�e Schwester", "Einstein", "m", 53, "einstein.jpeg",
				"schwester2.einstein@beuth-hochschule.de");

		defaultList.add(albert);
		defaultList.add(vater);
		defaultList.add(mutter);
		defaultList.add(schwester1);
		defaultList.add(bruder3);
		defaultList.add(schwester2);

		observableList = FXCollections.observableArrayList(defaultList);

		return observableList;
	}
}
