package fxge1.views;

import fxge1.models.Contact;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class ContactListCell extends ListCell<Contact> {
	VBox vbox = new VBox();
	Label name = new Label();
	Label mail = new Label();

	public ContactListCell() {
		super();
		vbox.getChildren().addAll(name, mail);

	}

	@Override
	protected void updateItem(Contact item, boolean empty) {

		super.updateItem(item, empty);
		setText(null);
		if (empty) {
			setGraphic(null);
		} else {
			name.setText(item.getlName() + "," + item.getfName());
			if (item.getEMail().size() == 0) {

				mail.setText("-- NO Mails Address--");
			} else {
				mail.setText("Primary Email: " + item.getEMail().get(0));
			}
			setGraphic(vbox);
		}

	}
}
