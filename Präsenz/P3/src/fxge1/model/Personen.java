package fxge1.model;

import java.util.ArrayList;

import org.w3c.dom.Element;

import fxge1.model.Tier.TierKlasse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personen {

	private static ArrayList<Person> defaultList;
	private static ObservableList<Person> observableList;

	public static void addPerson(Person person) {
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

		Person albert = new Person(Person.PersonTyp.besitzer, "Albert", "Einstein", "m", 53, "einstein.jpeg",
				"albert.einstein@beuth-hochschule.de");
		albert.addEmail("albert.einstein@beuth-hochschule.de");
		Tier flo = new Tier(TierKlasse.hund, "Jagdhund", 4, false, "Der Hund bellt", "Der Hund lebt bei den Menschen");
		flo.addName("Flo");
		Tier lilli = new Tier(TierKlasse.vogel, "Papagei", 5, false, "Der Vogel piept",
				"Der Vogel lebt in einer Voliere");
		lilli.addName("Lili");
		albert.addTier(flo);
		albert.addTier(lilli);

		Person vater = new Person(Person.PersonTyp.besitzer, "Vater", "Einstein", "m", 83, "einstein.jpeg",
				"vater.einstein@beuth-hochschule.de");
		Tier hans = new Tier(TierKlasse.vogel, "Sittich", 12, false, "Der Vogel piept",
				"Der Vogel lebt in einer Voliere");
		hans.addName("hans");
		vater.addTier(hans);

		Person mutter = new Person(Person.PersonTyp.nonbesiter, "Mutter", "Einstein", "w", 79, "einstein.jpeg",
				"mutter.einstein@beuth-hochschule.de");
		mutter.addEmail("mutter.einstein@beuth-hochschule.de");

		Person schwester1 = new Person(Person.PersonTyp.besitzer, "Kleine Schwester", "Einstein", "w", 34,
				"einstein.jpeg", "kleine.schwester.einstein@beuth-hochschule.de");
		Tier freddy = new Tier(TierKlasse.hund, "Dackel", 6, false, "Der Hund bellt", "Der Hund lebt bei den Menschen");
		freddy.addName("Freddy");
		schwester1.addTier(freddy);

		Person bruder1 = new Person(Person.PersonTyp.nonbesiter, "Kleiner Bruder", "Einstein", "m", 25, "einstein.jpeg",
				"kleiner.bruder.einstein@beuth-hochschule.de");
		bruder1.addEmail("kleiner.bruder.einstein@beuth-hochschule.de");
		bruder1.addEmail("kleiner.bruder.einstein@beuth-hochschule.de");

		Person schwester2 = new Person(Person.PersonTyp.nonbesiter, "Gro�e Schwester", "Einstein", "m", 53,
				"einstein.jpeg", "gro�e.schwester.einstein@beuth-hochschule.de");

		defaultList.add(albert);
		defaultList.add(vater);
		defaultList.add(mutter);
		defaultList.add(schwester1);
		defaultList.add(bruder1);
		defaultList.add(schwester2);

		observableList = FXCollections.observableArrayList(defaultList);

		return observableList;
	}
}
