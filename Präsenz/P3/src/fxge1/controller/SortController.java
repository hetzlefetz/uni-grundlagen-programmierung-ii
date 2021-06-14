package fxge1.controller;

import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import fxge1.model.Personen;
import fxge1.model.Tiere;
import fxge1.view.ShowPersonen;
import fxge1.view.ShowTiere;

public class SortController implements EventHandler<ActionEvent> {

	private BorderPane pane;
	private boolean person;

	public SortController(BorderPane pane, boolean person) {
		this.pane = pane;
		this.person = person;
	}

	@Override
	public void handle(ActionEvent e) {
		if (person) {
			Collections.sort(Personen.getAllPersonen());
			BorderPane bp = new ShowPersonen().show();
			pane.setCenter(bp);
		} else {
			Collections.sort(Tiere.getAllTiere());
			BorderPane bp = new ShowTiere().show();
			pane.setCenter(bp);
		}
	}
}
