package fxge1;

import java.util.ArrayList;

import fxge1.models.Contact;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class ContactRepository {
	private ArrayList<Contact> _contacts =  new ArrayList<Contact>());
	private ObservableList<Contact> _oContacts ;
	
	public ContactRepository() {
		_oContacts = FXCollections.observableList<Contact>(_contacts);
	}
	
	public void Add(Contact c) {
		_contacts.add(c);
	}
	
	public void Remove(Contact c ) {
		_contacts.remove(c);
	}
	public ObservableList<Contact> GetAll()
	{
		return _contacts;
	}
	
}
