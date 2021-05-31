package view;

import java.util.ArrayList;

import controller.InsertDialogController;
import controller.InsertPersonController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogPerson {

    private static int WIDTH = 400;
    private static int HEIGHT = 500;

    private Stage primaryStage;

    public DialogPerson(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage enterPerson() {

        Stage secondStage = new Stage();
        secondStage.setTitle("Bitte gebe die Persondaten ein");
        secondStage.initModality(Modality.WINDOW_MODAL);
        secondStage.initOwner(primaryStage);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 15, 15, 15));
        vbox.setAlignment(Pos.TOP_LEFT);

        Label label1 = new Label("Vorname");
        label1.setMinWidth(70);
        TextField vorname = new TextField();
        vorname.setMinWidth(50);
        ArrayList<Node> enter1 = new ArrayList<>();
        enter1.add(label1);
        enter1.add(vorname);
        HBox enter1box = Utils.setElementBox(enter1);

        Label label2 = new Label("Nachname");
        label2.setMinWidth(70);
        TextField nachname = new TextField();
        nachname.setMinWidth(50);
        ArrayList<Node> enter2 = new ArrayList<>();
        enter2.add(label2);
        enter2.add(nachname);
        HBox enter2box = Utils.setElementBox(enter2);

        Label label3 = new Label("Geschlecht");
        label3.setMinWidth(70);
        ToggleGroup group = new ToggleGroup();
        RadioButton w = new RadioButton("weiblich");
        RadioButton m = new RadioButton("maennlich");
        w.setToggleGroup(group);
        m.setToggleGroup(group);
        ArrayList<Node> enter3 = new ArrayList<>();
        enter3.add(label3);
        enter3.add(w);
        enter3.add(m);
        HBox enter3box = Utils.setElementBox(enter3);

        Label label4 = new Label("Alter");
        label4.setMinWidth(70);
        TextField alter = new TextField();
        alter.setMaxWidth(40);
        ArrayList<Node> enter4 = new ArrayList<>();
        enter4.add(label4);
        enter4.add(alter);
        HBox enter4box = Utils.setElementBox(enter4);

        Label label5 = new Label("Email");
        label5.setMinWidth(70);
        TextField email = new TextField();
        email.setMinWidth(50);
        ArrayList<Node> enter5 = new ArrayList<>();
        enter5.add(label5);
        enter5.add(email);
        HBox enter5box = Utils.setElementBox(enter5);

        Label label6 = new Label("Bild");
        label6.setMinWidth(70);
        TextField bild = new TextField();
        bild.setMinWidth(50);
        ArrayList<Node> enter6 = new ArrayList<>();
        enter6.add(label6);
        enter6.add(bild);
        HBox enter6box = Utils.setElementBox(enter6);

        Label label7 = new Label("Hat die Person ein Haustier?");
        label3.setMinWidth(70);

        // ToDo: RadioButton f�r Haustier ja/nein. Wenn ja, dann erschein der Tierdialog

        ArrayList<Node> enter7 = new ArrayList<>();
        var j = new RadioButton("Ja");
        var n = new RadioButton("Nein");
        enter7.add(label7);
        enter7.add(j);
        enter7.add(n);
        HBox enter7box = Utils.setElementBox(enter7);

        email.setOnMouseEntered(e -> {
            Tooltip t = new Tooltip(
                    "Die Emailadresse muss das Zeichen @ enthalten und\n	" + " mindestens 3 Zeichen lang sein");
            Tooltip.install(email, t);
        });

        Button submit = new Button("Submit");
        submit.setOnAction(new InsertPersonController(vorname, nachname, group, alter, bild, email, null));

        Button close = new Button("Schlie�en");
        close.setOnAction(e -> secondStage.close());

        ArrayList<Node> buttons = new ArrayList<>();
        buttons.add(submit);
        buttons.add(close);
        HBox buttonbox = Utils.setElementBox(buttons);

        vbox.getChildren().addAll(enter1box, enter2box, enter3box, enter4box, enter5box, enter6box, enter7box,
                buttonbox);

        secondStage.setScene(new Scene(vbox, WIDTH, HEIGHT));
        secondStage.setResizable(false);
        return secondStage;
    }
}
