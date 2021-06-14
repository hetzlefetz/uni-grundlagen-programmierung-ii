package fxge1.controller;

import fxge1.view.DialogXMLInsert;
import fxge1.view.DialogXMLRemove;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditXMLDialogController implements EventHandler<ActionEvent> {

	private char edit;
	private String file;
	private Stage primaryStage;

	public EditXMLDialogController(Stage primaryStage, String file, char edit) {
		this.edit = edit;
		this.file = file;
		this.primaryStage = primaryStage;
	}

	@Override
	public void handle(ActionEvent e) {
		if (edit == 'r') {
			Stage s = new DialogXMLRemove(primaryStage).removePerson("resouces", file);
			s.show();
		} else {
			Stage s = new DialogXMLInsert(primaryStage).enterPerson("resouces", file, true);
			s.show();
		}
	}
}
