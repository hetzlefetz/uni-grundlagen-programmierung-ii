package fxge1;

import java.io.IOException;
import java.net.URL;

import fxge1.views.ContactList;
import fxge1.views.ContactPane;
import fxge1.views.MainWindow;
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
	       
	    	var repo = new ContactRepository();
	    	var cl = new ContactList(repo);
	    	var cp = new ContactPane(null);
	    	var mw = new MainWindow(cl, cp);
	    	
	    	
	        Scene scene = new Scene(mw);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    
	   
}