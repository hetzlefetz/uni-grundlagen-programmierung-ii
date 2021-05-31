package view;

import java.util.ArrayList;

import controller.InsertPersonController;
import controller.UpdateController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Personen;
import model.Person;

public class ShowPersonen {
	
	private static int WIDTH = 700;
	private static int HEIGHT = 700;
	
	public BorderPane show() {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		
		ObservableList<Person> liste = Personen.getAllPersonen();
		liste.addListener(
						new UpdateController(root, liste, true));
		
		// alle elemente erstellen
		Text text = new Text("Einstein-Family");
		BorderPane.setAlignment(text, Pos.CENTER);
		text.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		text.setFill(Color.RED);
    	
        ScrollPanePerson scroll = new ScrollPanePerson(liste);
        
    	//elemente setzen
    	root.setTop(text);
    	root.setCenter(scroll);
        
        return root;
	}
}
