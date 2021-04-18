package fxge1.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {

	private StringProperty fName;
	private StringProperty profileBase64;
	private StringProperty lName;
	private StringProperty eMail;
	private BooleanProperty selected;

	public Contact(String fName, String lName, String eMail, String profileBase64) {
		this.fName = new SimpleStringProperty(fName);
		this.lName = new SimpleStringProperty(lName);
		this.eMail = new SimpleStringProperty(eMail);
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

	public String getEMail() {
		return this.eMail.get();
	}

	public StringProperty getlEmailProperty() {
		return this.eMail;
	}

	public void seteMail(String eMail) {
		this.eMail.set(eMail);
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
		sb.append("\"eMail\":\"" + getEMail() + "\",");
		sb.append(System.lineSeparator());
		sb.append("\"selected\":\"" + getSelected() + "\"");
		sb.append(System.lineSeparator());
		sb.append("}");
		return sb.toString();
	}
}