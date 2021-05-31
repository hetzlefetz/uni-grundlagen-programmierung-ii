package controller;

import java.util.ArrayList;

import application.Utils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Personen;
import model.Tiere;
import model.Person;
import model.Tier;
import view.DialogPerson;
import view.ShowPersonen;
import view.ShowTiere;

public class LoadController<E> implements EventHandler<ActionEvent> {
    
    private String filename;
    private BorderPane pane;
    private boolean person;
    
	public LoadController(BorderPane pane, String filename, boolean person) {
		this.filename = filename;
		this.person = person;
		this.pane = pane;
	}
    
   	@Override
   	public void handle(ActionEvent e) {
   		ArrayList<E> liste = Utils.leseDatenObjekt("Liste", filename);
   		if(!liste.isEmpty()) {
	   		if(person) {
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
