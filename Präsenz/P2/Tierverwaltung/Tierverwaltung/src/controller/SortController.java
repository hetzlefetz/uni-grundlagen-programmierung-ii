package controller;

import java.util.ArrayList;
import java.util.Collections;

import application.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Personen;
import model.Tiere;
import model.Person;
import model.Tier;
import view.ScrollPanePerson;
import view.ShowPersonen;
import view.ShowTiere;

public class SortController implements EventHandler<ActionEvent> {
    
    private BorderPane pane;
    private boolean person;
    
    public SortController(BorderPane pane, boolean person) {
		this.pane = pane;
		this.person = person;
	}
    
   	@Override
   	public void handle(ActionEvent e) {
   		if(person) {
   			Collections.sort(Personen.getAllPersonen());
   			BorderPane bp = new ShowPersonen().show();
   			pane.setCenter(bp);
   		} else {
   			
   			// ToDo: sortieren der Tierliste und anzeigen
   		}
   	}
}
