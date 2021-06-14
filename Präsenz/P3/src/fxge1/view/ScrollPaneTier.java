package fxge1.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import fxge1.model.Person;
import fxge1.model.Personen;
import fxge1.model.Tier;
import fxge1.model.Tiere;

public class ScrollPaneTier extends ScrollPane {

	public ScrollPaneTier(ObservableList<Tier> liste) {

		setPadding(new Insets(10, 10, 10, 10));

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);

		for (int i = 0; i < liste.size(); i++) {
			String txt = liste.get(i).toString();
			grid.add(setBox(txt), 0, i);
		}
		setContent(grid);
	}

	public HBox setBox(String txt) {
		Label txtLabel = new Label(txt);

		HBox grid = new HBox();
		grid.setSpacing(30);
		grid.setPadding(new Insets(20, 50, 20, 20));
		grid.setAlignment(Pos.TOP_LEFT);
		grid.getChildren().add(txtLabel);

		return grid;
	}
}
