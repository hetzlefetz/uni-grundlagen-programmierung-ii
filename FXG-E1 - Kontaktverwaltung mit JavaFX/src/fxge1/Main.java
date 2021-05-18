package fxge1;

import java.util.ArrayList;
import java.util.List;

import fxge1.views.ContactList;
import fxge1.views.ContactPane;
import fxge1.views.MainWindow;
import fxge1.models.Contact;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(Utils.GetDummyContact(0));
		contacts.add(Utils.GetDummyContact(1));
		contacts.add(Utils.GetDummyContact(2));
		contacts.add(Utils.GetDummyContact(3));
		var repo = new ContactRepository(contacts);
		var cl = new ContactList(repo);
		var cp = new ContactPane(repo);
		var mw = new MainWindow(cl, cp);

		Scene scene = new Scene(mw);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}