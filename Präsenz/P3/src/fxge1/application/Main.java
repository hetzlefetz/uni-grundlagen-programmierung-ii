package fxge1.application;

import javafx.application.Application;
import javafx.stage.Stage;
import fxge1.view.Menue;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			new Menue().show(primaryStage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
