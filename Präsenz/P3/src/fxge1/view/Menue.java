package fxge1.view;

import fxge1.controller.EditXMLDialogController;
import fxge1.controller.InsertDialogController;
import fxge1.controller.LoadController;
import fxge1.controller.SortController;
import fxge1.controller.SaveController;
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

        MenuBar bar = new MenuBar();
        Menu mainmenu = new Menu("Tierwelt");

        Menu mfile = new Menu("File");

        Menu mload = new Menu("Load");
        MenuItem ltier = new MenuItem("Tier");
        ltier.setOnAction(new LoadController(pane, "Tiere.txt", false));

        MenuItem lperson = new MenuItem("Person");
        lperson.setOnAction(new LoadController(pane, "Personen.txt", true));

        Menu msave = new Menu("Save");
        MenuItem stier = new MenuItem("Tier");
        stier.setOnAction(new SaveController("Tiere.txt", false));

        MenuItem sperson = new MenuItem("Person");
        sperson.setOnAction(new SaveController("Personen.txt", true));

        MenuItem mexit = new MenuItem("Exit");
        mexit.setOnAction(e -> primaryStage.close());

        mfile.getItems().addAll(mload, msave, mexit);
        mload.getItems().addAll(ltier, lperson);
        msave.getItems().addAll(stier, sperson);

        Menu medit = new Menu("Edit");

        Menu minsert = new Menu("Insert");
        MenuItem iTier = new MenuItem("Tier");
        iTier.setOnAction(new InsertDialogController(primaryStage, false, false));
        MenuItem iPerson = new MenuItem("Person");
        iPerson.setOnAction(new InsertDialogController(primaryStage, true, false));
        minsert.getItems().addAll(iTier, iPerson);

        MenuItem mdelete = new MenuItem("Delete");
        MenuItem mchange = new MenuItem("Change");

        medit.getItems().addAll(minsert, mdelete, mchange);

        Menu msort = new Menu("Sort");
        MenuItem tier = new MenuItem("Tier");
        tier.setOnAction(new SortController(pane, false));
        MenuItem person = new MenuItem("Person");
        person.setOnAction(new SortController(pane, true));

        msort.getItems().addAll(tier, person);

        // ToDo XML

        bar.getMenus().addAll(mfile, medit, msort);
        pane.setTop(bar);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tierwelt");
        primaryStage.show();
    }
}