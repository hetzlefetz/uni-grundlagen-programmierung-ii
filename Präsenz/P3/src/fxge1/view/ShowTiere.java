package fxge1.view;

import fxge1.controller.UpdateController;
import fxge1.model.Tier;
import fxge1.model.Tiere;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ShowTiere {

	private static int WIDTH = 700;
	private static int HEIGHT = 700;

	public BorderPane show() {
		BorderPane root = new BorderPane();

		root.setPadding(new Insets(20, 20, 20, 20));

		ObservableList<Tier> liste = Tiere.getAllTiere();
		liste.addListener(new UpdateController(root, liste, false));

		// alle elemente erstellen
		Text text = new Text("Tierwelt");
		BorderPane.setAlignment(text, Pos.CENTER);
		text.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		text.setFill(Color.RED);

		ScrollPaneTier scroll = new ScrollPaneTier(liste);

		// elemente setzen
		root.setTop(text);
		root.setCenter(scroll);

		return root;
	}
}
