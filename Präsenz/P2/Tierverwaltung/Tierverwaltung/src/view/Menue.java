package view;

import controller.InsertDialogController;
import controller.LoadController;
import controller.SortController;
import controller.SaveController;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menue {

	private static int WIDTH = 700;
	private static int HEIGHT = 700;

	public void show(Stage primaryStage) {

		BorderPane pane = new BorderPane();

		final var menu1 = new Menu("File");

		final var menu1Load = new Menu("Load");
		final var menu1LoadPerson = new MenuItem("Person");
		menu1LoadPerson.setOnAction(new LoadController<>(pane, "person.txt", true));
		final var menu1LoadTier = new MenuItem("Tier");
		menu1LoadPerson.setOnAction(new LoadController<>(pane, "tier.txt", false));
		menu1Load.getItems().addAll(menu1LoadPerson, menu1LoadTier);

		final var menu1Save = new Menu("Save");
		final var menu1SavePerson = new MenuItem("Person");
		menu1SavePerson.setOnAction(new SaveController<>("person.txt", true));
		final var menu1SaveTier = new MenuItem("Tier");
		menu1SaveTier.setOnAction(new SaveController<>("tier.txt", false));
		menu1Save.getItems().addAll(menu1SavePerson, menu1SaveTier);

		final var menu1Exit = new MenuItem("Exit");
		menu1Exit.setOnAction(e -> System.exit(0));
		menu1.getItems().addAll(menu1Save, menu1Load, menu1Exit);

		final var menu2 = new Menu("Edit");
		final var menu2Insert = new Menu("Insert");
		final var menu2InsertPerson = new MenuItem("Person");
		menu2InsertPerson.setOnAction(new InsertDialogController(primaryStage, true, false));
		final var menu2InsertTier = new Menu("Tier");
		final var menu2InsertTierHaustier = new MenuItem("Haustier");
		final var menu2InsertTierWildTier = new MenuItem("Wildtier");
		menu2InsertTierHaustier.setOnAction(new InsertDialogController(primaryStage, false, true));
		menu2InsertTierWildTier.setOnAction(new InsertDialogController(primaryStage, false, false));
		menu2InsertTier.getItems().addAll(menu2InsertTierHaustier, menu2InsertTierWildTier);

		menu2Insert.getItems().addAll(menu2InsertPerson, menu2InsertTier);
		final var menu2Delete = new MenuItem("Delete");
		final var menu2Change = new MenuItem("Change");

		menu2.getItems().addAll(menu2Insert, menu2Delete, menu2Change);

		final var menu3 = new Menu("Sort");

		final var menu3person = new MenuItem("Person");
		menu3person.setOnAction(new SortController(pane, true));
		final var menu3tier = new MenuItem("Tier");
		menu3tier.setOnAction(new SortController(pane, false));
		menu3.getItems().addAll(menu3person, menu3tier);

		MenuBar bar = new MenuBar();
		bar.getMenus().addAll(menu1, menu2, menu3);

		pane.setTop(bar);

		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tierwelt");
		primaryStage.show();
	}
}