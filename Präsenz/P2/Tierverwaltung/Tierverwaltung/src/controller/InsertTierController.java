package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Fisch;
import model.Großkatze;
import model.Hund;
import model.Tiere;
import model.Vogel;

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

		switch (g.getId()) {
			case "ID1": {
				Tiere.addTier(
						new Hund(this.art.getText(), Integer.parseInt(this.alter.getText()), this.name.getText()));
				((Stage) g.getScene().getWindow()).close();
				break;
			}
			case "ID2": {
				Tiere.addTier(
						new Vogel(this.art.getText(), Integer.parseInt(this.alter.getText()), this.name.getText()));
				((Stage) g.getScene().getWindow()).close();
				break;
			}
			case "ID3": {
				Tiere.addTier(new Großkatze(this.art.getText(), Integer.parseInt(this.alter.getText())));
				((Stage) g.getScene().getWindow()).close();
				break;
			}
			case "ID4": {
				Tiere.addTier(new Fisch(this.art.getText(), Integer.parseInt(this.alter.getText())));
				((Stage) g.getScene().getWindow()).close();
				break;
			}
		}
	}
}
