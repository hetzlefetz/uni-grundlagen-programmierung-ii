package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import model.Person;
import model.Personen;
import model.Tier;
import model.Tiere;
import view.ScrollPanePerson;
import view.ScrollPaneTier;
import view.ShowPersonen;

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
		if(person) {
			ObservableList<Person> oliste = (ObservableList<Person>) liste;
			ScrollPanePerson scroll = new ScrollPanePerson(oliste);
			pane.setCenter(scroll);
		}
		else { 
			ObservableList<Tier> oliste = (ObservableList<Tier>) liste;
			ScrollPaneTier scroll = new ScrollPaneTier(oliste);
			pane.setCenter(scroll);
		}
   		
	}
}
