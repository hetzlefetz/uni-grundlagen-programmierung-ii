package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.DialogPerson;
import view.DialogTier;

public class InsertDialogController implements EventHandler<ActionEvent> {
 
    private Stage primaryStage;
    private boolean person;
    private boolean home;
    
	public InsertDialogController(Stage primaryStage, boolean person, boolean home) {
		this.primaryStage = primaryStage;
		this.person = person;
		this.home = home;
	}
    
   	@Override
   	public void handle(ActionEvent e) {
   		if(person) {
   			DialogPerson dialog = new DialogPerson(primaryStage);
   			Stage s = dialog.enterPerson();
   			s.show();
   		} else {
			DialogTier dialog = new DialogTier(primaryStage);
			Stage s = dialog.enterTier(home);
			s.show();
   		}
   	}
}
