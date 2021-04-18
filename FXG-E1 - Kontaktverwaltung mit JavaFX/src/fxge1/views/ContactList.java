package fxge1.views;

import fxge1.ContactRepository;
import fxge1.models.Contact;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class ContactList extends ListView<Contact> {

	private ContactRepository contactRepository;

	public ContactList(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
		this.setItems(this.contactRepository.GetAll());
		this.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
			@Override
			public ListCell<Contact> call(ListView<Contact> contactListView) {
				return new ContactListCell();
			}
		});

		this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
			public void changed(ObservableValue<? extends Contact> observable, Contact oldValue, Contact newValue) {
				System.out.println("selection changed");
				if (oldValue != null) {
					oldValue.getSelectedProperty().set(false);
				}
				if (newValue != null) {
					newValue.getSelectedProperty().set(true);
				}
			}
		});
	}

}
