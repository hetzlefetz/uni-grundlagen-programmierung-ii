package fxge1.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogXMLRemove {

	private static int WIDTH = 400;
	private static int HEIGHT = 500;

	private Stage primaryStage;

	public DialogXMLRemove(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage removePerson(String verz, String filename) {

		Stage secondStage = new Stage();
		secondStage.setTitle("Person aus XML l�schen");
		secondStage.initModality(Modality.WINDOW_MODAL);
		secondStage.initOwner(primaryStage);

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setAlignment(Pos.TOP_LEFT);

		Label label1 = new Label("Id");
		label1.setMinWidth(70);
		TextField id = new TextField();
		id.setMinWidth(50);
		ArrayList<Node> enter1 = new ArrayList<>();
		enter1.add(label1);
		enter1.add(id);
		HBox enter1box = Utils.setElementBox(enter1);

		Label label2 = new Label("Dateiname");
		label2.setMinWidth(70);
		TextField datei = new TextField();
		datei.setMinWidth(50);
		ArrayList<Node> enter2 = new ArrayList<>();
		enter2.add(label2);
		enter2.add(datei);
		HBox enter2box = Utils.setElementBox(enter2);

		Button submit = new Button("Submit");
		submit.setOnAction(e -> XMLDokument.remove("resources", datei.getText(), id.getText()));

		Button close = new Button("Schlie�en");
		close.setOnAction(e -> secondStage.close());

		ArrayList<Node> buttons = new ArrayList<>();
		buttons.add(submit);
		buttons.add(close);
		HBox buttonbox = Utils.setElementBox(buttons);

		vbox.getChildren().addAll(enter2box, enter1box, buttonbox);

		secondStage.setScene(new Scene(vbox, WIDTH, HEIGHT));
		secondStage.setResizable(false);
		return secondStage;
	}
}
