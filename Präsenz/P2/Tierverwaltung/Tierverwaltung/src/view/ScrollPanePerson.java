package view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Person;

public class ScrollPanePerson extends ScrollPane {
	
	public ScrollPanePerson(ObservableList<Person> personen) {
		
	    setPadding(new Insets(10, 10, 10, 10));
	  
	    GridPane grid = new GridPane();
	    grid.setAlignment(Pos.TOP_LEFT);
     	
		for(int i = 0;i < personen.size();i++) {
        	String txt = personen.get(i).toString();
        	Image img = new Image (getClass().
        								getResource("/resources/" + personen.get(i).getImage()).
        								toString());
        	
        	grid.add(setBox(txt, img), 0, i);
        }
		setContent(grid);
	}
	
	public HBox setBox(String txt, Image img) {
		Label txtLabel = new Label(txt);
		ImageView iView = new ImageView(img);
        HBox grid = new HBox();
        grid.setSpacing(30);
        grid.setPadding(new Insets(20, 50, 20, 20));
  	  	grid.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().addAll(iView, txtLabel);
        
        return grid;
    }
}
