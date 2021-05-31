package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tiere {

	private static ArrayList<Tier> defaultList;
	private static ObservableList<Tier> observableList;

	private static Tier last;

	public static void addTier(Tier tier) {
		observableList.add(tier);
		last = tier;
	}

	public static Tier getLast() {
		return last;
	}

	public static void setList(ArrayList<Tier> liste) {
		observableList = FXCollections.observableArrayList(liste);
	}

	public static ObservableList<Tier> getAllTiere() {
		return observableList;
	}

	public static ObservableList<Tier> getDefaultList() {

		defaultList = new ArrayList<>();

		Tier hund1 = new Hund("Jagdhund", 4, "Flo");
		Tier fisch1 = new Fisch("Forelle", 10);
		Tier vogel1 = new Vogel("Papagei", 5, "Lili");
		Tier hund2 = new Hund("Dackel", 3, "Freddy");
		Tier katze1 = new Großkatze("Tiger", 4);
		Tier hund3 = new Hund("Dalmatiner", 10, "Franz");
		Tier vogel2 = new Vogel("Sittich", 12, "Hans");
		Tier katze2 = new Großkatze("Loewe", 7);
		Tier fisch2 = new Fisch("Aal", 15);

		defaultList.add(hund1);
		defaultList.add(fisch1);
		defaultList.add(vogel1);
		defaultList.add(hund2);
		defaultList.add(katze1);
		defaultList.add(hund3);
		defaultList.add(vogel2);
		defaultList.add(katze2);
		defaultList.add(fisch2);

		observableList = FXCollections.observableArrayList(defaultList);

		return observableList;
	}
}
