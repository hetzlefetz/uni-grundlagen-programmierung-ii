package fxge1;

import fxge1.models.Contact;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.beans.Observable;

public class ContactRepository {

	private ObservableList<Contact> _oContacts;

	public ContactRepository(List<Contact> contacts) {
		_oContacts = FXCollections.observableArrayList(new Callback<Contact, Observable[]>() {
			@Override
			public Observable[] call(Contact param) {
				return new Observable[] { param.getfNameProperty(), param.getlNameProperty(), param.getlEmailProperty(),
						param.getSelectedProperty() };
			}
		});

		_oContacts.addAll(contacts);
	}

	public void Add(Contact c) {
		_oContacts.add(c);
	}

	public void Remove(Contact c) {
		_oContacts.remove(c);
	}

	public ObservableList<Contact> GetAll() {
		return _oContacts;
	}

}
