package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Personen;
import model.Tier;
import model.Tiere;
import model.Besitzer;
import model.NonBesitzer;
import model.Person;
import view.ShowPersonen;
import view.ShowTiere;

public class InsertPersonController implements EventHandler<ActionEvent> {

	private TextField vorname;
	private TextField nachname;
	private ToggleGroup geschlecht;
	private ToggleGroup tier;
	private TextField alter;
	private TextField bild;
	private TextField email;

	public InsertPersonController(TextField vorname, TextField nachname, ToggleGroup geschlecht, TextField alter,
			TextField bild, TextField email, ToggleGroup tier) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
		this.alter = alter;
		this.bild = bild;
		this.email = email;
		this.tier = tier;
	}

	@Override
	public void handle(ActionEvent e) {
		RadioButton g = (RadioButton) geschlecht.getSelectedToggle();
		RadioButton t = (RadioButton) tier.getSelectedToggle();

		if (t.getText().equals("Ja")) {
			var tierC = new InsertDialogController((Stage) vorname.getScene().getWindow(), false, true);
			tierC.handle(e);
			Besitzer b = new Besitzer(vorname.getText(), nachname.getText(), g.getText(),
					Integer.parseInt(alter.getText()), bild.getText(), email.getText());

			b.addTier(Tiere.getLast());

			Personen.addDefault(b);
		} else {
			NonBesitzer b = new NonBesitzer(vorname.getText(), nachname.getText(), g.getText(),
					Integer.parseInt(alter.getText()), bild.getText(), email.getText());

			Personen.addDefault(b);
		}

		vorname.clear();
		nachname.clear();
		geschlecht.getToggles().clear();
		alter.clear();
		bild.clear();
		email.clear();
	}
}
