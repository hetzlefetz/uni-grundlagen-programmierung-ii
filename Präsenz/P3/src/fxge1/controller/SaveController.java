package fxge1.controller;

import fxge1.application.Utils;
import fxge1.model.Person;
import fxge1.model.Tier;
import fxge1.model.Tiere;
import fxge1.model.Personen;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SaveController<E> implements EventHandler<ActionEvent> {

	private String filename;
	private boolean person;

	public SaveController(String filename, boolean person) {
		this.filename = filename;
		this.person = person;
	}

	@Override
	public void handle(ActionEvent e) {
		if (person) {
			ObservableList<Person> oliste = Personen.getAllPersonen();
			if (oliste == null)
				oliste = Personen.getDefaultList();
			Utils.schreibeDatenObjekt(Utils.copyList(oliste), "resources", filename);
		} else {
			ObservableList<Tier> oliste = Tiere.getAllTiere();
			if (oliste == null)
				oliste = Tiere.getDefaultList();

			Utils.schreibeDatenObjekt(Utils.copyList(oliste), "resources", filename);
		}
	}
}
