package fxge1.controller;

import fxge1.model.Tier;
import fxge1.model.Tiere;
import fxge1.model.Tier.TierKlasse;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class InsertTierController implements EventHandler<ActionEvent> {

	private TextField name;
	private TextField art;
	private TextField alter;
	private ToggleGroup klasse;

	public InsertTierController(ToggleGroup klasse, TextField art, TextField name, TextField alter) {
		this.name = name;
		this.art = art;
		this.alter = alter;
		this.klasse = klasse;
	}

	@Override
	public void handle(ActionEvent e) {
		RadioButton g = (RadioButton) klasse.getSelectedToggle();
		if (g.getText().equals("Hund")) {
			Tier hund = new Tier(TierKlasse.hund, art.getText(), Integer.parseInt(alter.getText()), false,
					"Der Hund bellt", "Der Hund lebt bei den Menschen");
			hund.addName(name.getText());
			Tiere.addTier(hund);
		}

		if (g.getText().equals("Vogel")) {
			Tier vogel = new Tier(TierKlasse.vogel, art.getText(), Integer.parseInt(alter.getText()), false,
					"Der Vogel piept", "Der Vogel lebt in einer Voliere");
			vogel.addName(name.getText());
			Tiere.addTier(vogel);
		}

		if (g.getText().equals("grosskatze"))
			Tiere.addTier(new Tier(TierKlasse.grosskatze, art.getText(), Integer.parseInt(alter.getText()), true,
					"Die grosskatze br�llt", "Die grosskatze lebt in der Wildnis"));

		if (g.getText().equals("Fisch"))
			Tiere.addTier(new Tier(TierKlasse.fisch, art.getText(), Integer.parseInt(alter.getText()), false,
					"Der Fisch blubbert", "Der Fisch lebt im Wasser."));

		art.clear();
		name.clear();
		alter.clear();
		klasse.getToggles().clear();
	}
}
