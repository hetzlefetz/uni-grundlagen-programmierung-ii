package fxge1.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import fxge1.model.Tier.TierKlasse;

public class Tiere {

	private static ArrayList<Tier> defaultList;
	private static ObservableList<Tier> observableList;

	private static Tier last;

	public static void addTier(Tier tier) {
		if (observableList == null)
			observableList = getDefaultList();

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

		Tier hund1 = new Tier(TierKlasse.hund, "Jagdhund", 4, false, "Der Hund bellt",
				"Der Hund lebt bei den Menschen");
		hund1.addName("Flo");
		Tier fisch1 = new Tier(TierKlasse.fisch, "Aal", 5, false, "Der Fisch blubbert", "Der Fisch lebt im Wasser.");
		Tier vogel1 = new Tier(TierKlasse.vogel, "Papagei", 5, false, "Der Vogel piept",
				"Der Vogel lebt in einer Voliere");
		vogel1.addName("Steffie");
		Tier hund2 = new Tier(TierKlasse.hund, "Dackel", 6, false, "Der Hund bellt", "Der Hund lebt bei den Menschen");
		hund2.addName("Freddy");
		Tier katze1 = new Tier(TierKlasse.grosskatze, "Tiger", 6, true, "Die grosskatze br�llt",
				"Die grosskatze lebt in der Wildnis");
		Tier vogel2 = new Tier(TierKlasse.vogel, "Sittich", 12, false, "Der Vogel piept",
				"Der Vogel lebt in einer Voliere");
		vogel2.addName("Lilli");

		defaultList.add(hund1);
		defaultList.add(fisch1);
		defaultList.add(vogel1);
		defaultList.add(hund2);
		defaultList.add(katze1);
		defaultList.add(vogel2);

		observableList = FXCollections.observableArrayList(defaultList);

		return observableList;
	}
}
