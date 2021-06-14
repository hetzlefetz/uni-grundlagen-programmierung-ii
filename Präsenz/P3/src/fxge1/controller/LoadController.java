package fxge1.controller;

import java.util.ArrayList;

import fxge1.application.Utils;
import fxge1.model.Personen;
import fxge1.model.Tiere;
import fxge1.view.ShowPersonen;
import fxge1.view.ShowTiere;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;

import fxge1.model.Person;
import fxge1.model.Tier;

public class LoadController<E> implements EventHandler<ActionEvent> {

	private String filename;
	private BorderPane pane;
	private boolean person;
	private boolean xml;

	public LoadController(BorderPane pane, String filename, boolean person) {
		this.filename = filename;
		this.person = person;
		this.pane = pane;
	}

	@Override
	public void handle(ActionEvent e) {
		ArrayList<E> liste = Utils.leseDatenObjekt("resources", filename);
		if (!liste.isEmpty()) {
			if (person) {
				Personen.setList((ArrayList<Person>) liste);
				BorderPane bp = new ShowPersonen().show();
				pane.setCenter(bp);
			} else {
				Tiere.setList((ArrayList<Tier>) liste);
				BorderPane bp = new ShowTiere().show();
				pane.setCenter(bp);
			}
		}
	}
}
