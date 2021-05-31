package controller;

import java.util.ArrayList;

import application.Utils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Person;
import model.Personen;
import model.Tier;
import model.Tiere;

public class SaveController<E> implements EventHandler<ActionEvent> {
    
    private String filename;
    private boolean person;
    
	public SaveController(String filename, boolean person) {
		this.filename = filename;
		this.person = person;
	}
    
   	@Override
   	public void handle(ActionEvent e) {
   		if(person) {
   			ObservableList<Person> oliste = Personen.getAllPersonen();
   			if(oliste == null) 
   				oliste = Personen.getDefaultList();
   			Utils.schreibeDatenObjekt(Utils.copyList(oliste),"liste",filename);
   	   	} else {
   			ObservableList<Tier> oliste = Tiere.getAllTiere();
   			if(oliste == null) 
   				oliste = Tiere.getDefaultList();
   		
   			Utils.schreibeDatenObjekt(Utils.copyList(oliste),"liste",filename);
   	   	}
   	}
}
