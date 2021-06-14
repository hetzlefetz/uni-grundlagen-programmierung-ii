package fxge1.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import fxge1.model.Person;
import fxge1.model.Personen;
import fxge1.model.Person.PersonTyp;
import fxge1.view.XMLDokument;
import fxge1.model.Tiere;

public class InsertPersonController implements EventHandler<ActionEvent> {

	private TextField vorname;
	private TextField nachname;
	private ToggleGroup geschlecht;
	private ToggleGroup tier;
	private TextField alter;
	private TextField bild;
	private TextField email;
	private TextField filename;

	public InsertPersonController(TextField vorname, TextField nachname, ToggleGroup geschlecht, TextField alter,
			TextField bild, TextField email, ToggleGroup tier, TextField filename) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.alter = alter;
		this.bild = bild;
		this.email = email;
		this.tier = tier;
		this.filename = filename;
	}

	@Override
	public void handle(ActionEvent e) {
		RadioButton g = (RadioButton) geschlecht.getSelectedToggle();
		RadioButton t = (RadioButton) tier.getSelectedToggle();
		if (t.getText().equals("ja")) {
			Person b = new Person(PersonTyp.besitzer, vorname.getText(), nachname.getText(), g.getText(),
					Integer.parseInt(alter.getText()), bild.getText(), email.getText());
			b.addTier(Tiere.getLast());
			if (filename != null)
				XMLDokument.insert("resources", filename.getText(), b);
			else {
				Personen.addPerson(b);
			}
		} else {
			Person b = new Person(PersonTyp.nonbesiter, vorname.getText(), nachname.getText(), g.getText(),
					Integer.parseInt(alter.getText()), bild.getText(), email.getText());
			if (filename != null)
				XMLDokument.insert("resources", filename.getText(), b);
			else {
				Personen.addPerson(b);
			}
		}

		vorname.clear();
		nachname.clear();
		geschlecht.getToggles().clear();
		alter.clear();
		bild.clear();
		email.clear();
		if (filename != null)
			filename.clear();
	}
}
