package fxge1.views;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class MainWindow extends javafx.scene.layout.GridPane {

	public MainWindow(ContactList list, ContactPane pane) {
		var c1 = new ColumnConstraints();
		c1.setPercentWidth(20);
		var c2 = new ColumnConstraints();
		c2.setPercentWidth(80);
		
		
		this.getColumnConstraints().add(c1); 
		this.getColumnConstraints().add(c2);
		     
		
		this.add(list, 0, 0);
		this.add(pane, 1, 0);

		GridPane.setVgrow(list, Priority.ALWAYS);
		GridPane.setVgrow(pane, Priority.ALWAYS);
		
	}
}
