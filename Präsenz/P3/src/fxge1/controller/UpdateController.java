package fxge1.controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import fxge1.view.ScrollPanePerson;
import fxge1.view.ScrollPaneTier;
import fxge1.model.Person;
import fxge1.model.Tier;
import fxge1.model.Tiere;

public class UpdateController<E> implements ListChangeListener {

	private BorderPane pane;
	private boolean person;
	ObservableList<E> liste;

	public UpdateController(BorderPane pane, ObservableList<E> liste, boolean person) {
		this.pane = pane;
		this.person = person;
		this.liste = liste;
	}

	@Override
	public void onChanged(Change arg0) {
		if (person) {
			ObservableList<Person> oliste = (ObservableList<Person>) liste;
			ScrollPanePerson scroll = new ScrollPanePerson(oliste);
			pane.setCenter(scroll);
		} else {
			ObservableList<Tier> oliste = (ObservableList<Tier>) liste;
			ScrollPaneTier scroll = new ScrollPaneTier(oliste);
			pane.setCenter(scroll);
		}
	}
}
