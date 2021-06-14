package fxge1.view;

import java.util.ArrayList;

import fxge1.controller.InsertTierController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogTier {

	private static int WIDTH = 400;
	private static int HEIGHT = 400;

	private Stage primaryStage;

	public DialogTier(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage enterTier(boolean home) {

		Stage secondStage = new Stage();
		secondStage.setTitle("Bitte gebe die Tierdaten ein");
		secondStage.initModality(Modality.WINDOW_MODAL);
		secondStage.initOwner(primaryStage);

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setAlignment(Pos.TOP_LEFT);

		Label label1 = new Label("Art");
		label1.setMinWidth(70);
		TextField art = new TextField();
		art.setMinWidth(50);
		ArrayList<Node> enter1 = new ArrayList<>();
		enter1.add(label1);
		enter1.add(art);
		HBox enter1box = Utils.setElementBox(enter1);

		Label label2 = new Label("Name");
		label2.setMinWidth(70);
		TextField name = new TextField();
		name.setMinWidth(50);
		ArrayList<Node> enter2 = new ArrayList<>();
		enter2.add(label2);
		enter2.add(name);
		HBox enter2box = Utils.setElementBox(enter2);

		if (!home)
			setNotHome(label2, name);

		Label label3 = new Label("Alter");
		label3.setMinWidth(70);
		TextField alter = new TextField();
		alter.setMaxWidth(40);
		ArrayList<Node> enter3 = new ArrayList<>();
		enter3.add(label3);
		enter3.add(alter);
		HBox enter3box = Utils.setElementBox(enter3);

		Label label4 = new Label("Klasse?");
		label4.setMinWidth(70);
		ArrayList<Node> enter4 = new ArrayList<>();
		enter4.add(label4);

		ToggleGroup group4 = new ToggleGroup();
		RadioButton h = new RadioButton("Hund");
		h.setToggleGroup(group4);
		h.setOnAction(e -> setHome(label2, name));
		enter4.add(h);
		RadioButton v = new RadioButton("Vogel");
		v.setToggleGroup(group4);
		v.setOnAction(e -> setHome(label2, name));
		enter4.add(v);

		if (!home) {
			RadioButton g = new RadioButton("grosskatze");
			g.setOnAction(e -> setNotHome(label2, name));
			RadioButton f = new RadioButton("Fisch");
			f.setOnAction(e -> setNotHome(label2, name));
			g.setToggleGroup(group4);
			f.setToggleGroup(group4);
			enter4.add(g);
			enter4.add(f);
		}

		HBox enter4box = Utils.setElementBox(enter4);

		Button submit = new Button("Submit");
		submit.setOnAction(new InsertTierController(group4, art, name, alter));

		Button close = new Button("Schlie�en");
		close.setOnAction(e -> secondStage.close());

		ArrayList<Node> buttons = new ArrayList<>();
		buttons.add(submit);
		buttons.add(close);
		HBox buttonbox = Utils.setElementBox(buttons);

		vbox.getChildren().addAll(enter4box, enter1box, enter3box, enter2box, buttonbox);

		secondStage.setScene(new Scene(vbox, WIDTH, HEIGHT));
		secondStage.setResizable(false);
		return secondStage;
	}

	public void setHome(Label l, TextField f) {
		l.setVisible(true);
		f.setVisible(true);
	}

	public void setNotHome(Label l, TextField f) {
		l.setVisible(false);
		f.setVisible(false);
	}
}
