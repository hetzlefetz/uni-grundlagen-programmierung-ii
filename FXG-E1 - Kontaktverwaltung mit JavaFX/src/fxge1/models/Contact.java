package fxge1.models;

import java.util.ArrayList;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contact {

	private StringProperty fName;
	private StringProperty profileBase64;
	private StringProperty lName;
	private SimpleListProperty<String> eMails;
	private BooleanProperty selected;

	public Contact(String fName, String lName, ArrayList<String> eMails, String profileBase64) {
		this.fName = new SimpleStringProperty(fName);
		this.lName = new SimpleStringProperty(lName);
		this.eMails = new SimpleListProperty<String>(FXCollections.observableArrayList(eMails));
		this.profileBase64 = new SimpleStringProperty(profileBase64);
		this.selected = new SimpleBooleanProperty(false);

	}

	public void setSelected(boolean selected) {
		this.selected.set(selected);
	}

	public boolean getSelected() {
		return this.selected.get();
	}

	public BooleanProperty getSelectedProperty() {
		return this.selected;
	}

	public String getfName() {
		return this.fName.get();
	}

	public StringProperty getfNameProperty() {
		return this.fName;
	}

	public void setfName(String fName) {
		this.fName.set(fName);
	}

	public String getProfileBase64() {
		return this.profileBase64.get();
	}

	public StringProperty getProfileBase64Property() {
		return this.profileBase64;
	}

	public void setProfileBase64(String profileBase64) {
		this.profileBase64.set(profileBase64);
	}

	public String getlName() {
		return this.lName.get();
	}

	public StringProperty getlNameProperty() {
		return this.lName;
	}

	public void setlName(String lName) {
		this.lName.set(lName);
	}

	public ObservableList<String> getEMail() {
		return this.eMails.get();
	}

	public ListProperty<String> getEmailsProperty() {
		return this.eMails;
	}

	public void addEmail(String mail) {
		this.eMails.get().add(mail);
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();
		sb.append("{");
		sb.append(System.lineSeparator());
		sb.append("\"fname\":\"" + getfName() + "\",");
		sb.append(System.lineSeparator());
		sb.append("\"lName\":\"" + getlName() + "\",");
		sb.append(System.lineSeparator());
		sb.append("\"eMails\":\"[" + String.join(",", getEMail()) + "\"],");
		sb.append(System.lineSeparator());
		sb.append("\"selected\":\"" + getSelected() + "\"");
		sb.append(System.lineSeparator());
		sb.append("}");
		return sb.toString();
	}
}