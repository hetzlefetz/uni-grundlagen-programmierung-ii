package fxge1.views;

import fxge1.ContactRepository;
import fxge1.models.Contact;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class ContactList extends ListView<Contact>{
	
	public ContactList(ContactRepository contact) {
		this.setItems(contact.getAll());
		this.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
		    @Override
		    public ListCell<Contact> call(ListView<Contact> contactListView) {
		        return new ContactListCell();
		    }
		});
	}

}
