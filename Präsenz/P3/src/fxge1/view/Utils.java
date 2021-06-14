package fxge1.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Utils {

	public static HBox setElementBox(ArrayList<Node> elements) {
		HBox hbox = new HBox();
		hbox.setSpacing(5);
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setAlignment(Pos.TOP_LEFT);
		for (Node elem : elements)
			hbox.getChildren().add(elem);

		return hbox;
	}
}
