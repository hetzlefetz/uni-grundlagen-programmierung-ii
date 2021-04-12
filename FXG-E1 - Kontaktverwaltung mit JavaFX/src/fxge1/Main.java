package fxge1;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
	 public static void main(String[] args) {
	        launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        FXMLLoader loader = new FXMLLoader();
	        var resource = getClass().getResource("views/MainWindow.fxml");
	        System.out.println(resource);
	        loader.setLocation(resource);
	        VBox vbox = loader.<VBox>load();

	        Scene scene = new Scene(vbox);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    
	    // loads an FXML file from a location relative to this class.
	    public static <T> T load(String loc) throws IOException {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource(loc));
	        return loader.load();
	    }
}