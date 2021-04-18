package fxge1.views;

import fxge1.ContactRepository;
import fxge1.Utils;
import fxge1.models.Contact;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.collections.ListChangeListener;

public class ContactPane extends javafx.scene.layout.GridPane {

	final String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	final String errorStyle = "-fx-text-fill: white;-fx-border-insets: 0;-fx-border-width: 2px;-fx-border-color: red;-fx-border-style: hidden hidden solid hidden;-fx-background-color: derive(red, 99%);";
	final String normalStyle = "-fx-text-fill: black;-fx-border-insets: 0;-fx-border-width: 2px;-fx-border-color: grey;-fx-border-style: hidden hidden solid hidden;-fx-background-color:white;";
	private ContactRepository contacts;

	public ContactPane(ContactRepository repo) {

		this.contacts = repo;
		setNoSelectionContent();

		repo.GetAll().addListener(new ListChangeListener<Contact>() {
			@Override
			public void onChanged(Change<? extends Contact> c) {
				while (c.next()) {
					if (c.wasPermutated()) {
						for (int i = c.getFrom(); i < c.getTo(); ++i) {
							System.out.println("Permuted: " + i + " " + contacts.GetAll().get(i));
						}
					} else if (c.wasUpdated()) {
						for (int i = c.getFrom(); i < c.getTo(); ++i) {
							System.out.println("Updated: " + i + " " + contacts.GetAll().get(i));
							if (contacts.GetAll().get(i).getSelected()) {
								setSelectedContent(contacts.GetAll().get(i));
							}
						}
					} else {
						for (Contact removedItem : c.getRemoved()) {
							System.out.println("Removed: " + removedItem);
						}
						for (Contact addedItem : c.getAddedSubList()) {
							System.out.println("Added: " + addedItem);
						}
					}
				}
			}
		});
	}

	private void setNoSelectionContent() {
		this.getChildren().clear();
		this.getColumnConstraints().clear();
		ColumnConstraints col = new ColumnConstraints();
		col.setHalignment(HPos.CENTER);
		this.getColumnConstraints().add(col);
		RowConstraints row = new RowConstraints();
		row.setValignment(VPos.CENTER);
		this.getRowConstraints().add(row);
		this.add(new Label("Bitte einen Kontakt auswählen"), 0, 0);
	}

	private void setSelectedContent(Contact c) {
		this.getChildren().clear();
		this.getColumnConstraints().clear();
		var cc1 = new ColumnConstraints();
		cc1.setPercentWidth(50);
		var cc2 = new ColumnConstraints();
		cc2.setPercentWidth(50);
		this.paddingProperty().set(new Insets(10));
		this.add(new Label("Name:"), 0, 0);
		this.add(new Label("Vorname:"), 0, 2);
		this.add(new Label("E-Mail:"), 0, 4);
		this.setHgap(25);

		var mailInput = new TextField(c.getEMail());
		mailInput.setStyle(normalStyle);

		var lnameInput = new TextField(c.getlName());
		lnameInput.setStyle(normalStyle);
		this.add(lnameInput, 0, 1);

		var fNameInput = new TextField(c.getfName());
		fNameInput.setStyle(normalStyle);
		this.add(fNameInput, 0, 3);

		this.add(mailInput, 0, 5);
		mailInput.textProperty().addListener(event -> {
			System.out.println("Changed");
			if (!mailInput.getText().isEmpty() && !mailInput.getText().matches(emailRegex)) {
				mailInput.setStyle(errorStyle);
				System.out.println("Match");

			} else {
				System.out.println("Doesnt match");
				mailInput.setStyle(normalStyle);
			}
		}

		);

		var image = new ImageView(new Image(Utils.InputStreamFromBase64(c.getProfileBase64()), 100, 100, true, true));
		this.add(image, 1, 0, 1, 4);
	}
}
