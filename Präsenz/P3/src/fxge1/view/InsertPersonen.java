package fxge1.view;

import java.util.ArrayList;

import fxge1.controller.UpdateController;
import fxge1.model.Person;
import fxge1.model.Personen;
import fxge1.model.Tier;
import fxge1.model.Tiere;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsertPersonen {

	private static int WIDTH = 600;
	private static int HEIGHT = 700;

	private BorderPane root;

	public void show(Stage primaryStage) {
		root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));

		ObservableList<Person> personList = Personen.getDefaultList();
		// personList.addListener(
		// new UpdateController(root, personList));

		// alle elemente erstellen
		Text text = new Text("Einstein-Family");
		BorderPane.setAlignment(text, Pos.CENTER);
		text.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		text.setFill(Color.RED);

		Button close = new Button("Fertig");
		close.setPadding(new Insets(10, 10, 10, 10));
		close.setMaxWidth(150);
		close.setMaxHeight(30);
		close.setOnAction(e -> primaryStage.close());

		Button enter = new Button("Neuer Kontakt");
		enter.setPadding(new Insets(10, 10, 10, 10));
		enter.setMaxWidth(150);
		enter.setMaxHeight(30);
		// enter.setOnAction(
		// new DialogController(primaryStage, personList));

		ScrollPanePerson scroll = new ScrollPanePerson(personList);

		ArrayList<Node> nodes = new ArrayList<>();
		nodes.add(enter);
		nodes.add(close);

		HBox hbox = Utils.setElementBox(nodes);

		// elemente setzen
		root.setTop(text);
		root.setCenter(scroll);
		root.setBottom(hbox);

		Scene scene = new Scene(root, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
