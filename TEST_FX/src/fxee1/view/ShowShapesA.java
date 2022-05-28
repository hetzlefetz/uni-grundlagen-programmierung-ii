package fxee1.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to represent graphically an Array of Shape-objects.
 * A Shape Object can be a rectangle or a circle.
 * The shapes appear with their real dimensions and positions,
 * and their area (number rounded) displayed at their origin.
 * @author agathe merceron
 */

import fxee1.model.MAllShapes;
import fxee1.model.MCircle;
import fxee1.model.MEllipse;
import fxee1.model.MRectangle;
import fxee1.model.MShape;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowShapesA extends Application {

    private static final double WIDTH = 400;
    private static final double NUMBER = 5;
    private static final double DECREMENT = 20;

    @Override
    public void start(Stage primaryStage) {
        try {
            Group root = new Group();
            double rwidth = WIDTH / NUMBER;
            double length = WIDTH / 3;
            double x = 0;
            double y = DECREMENT;
            for (int i = 0; i < NUMBER; i++) {
                Rectangle r1 = new Rectangle(x, y, rwidth, length);
                root.getChildren().add(r1);
                x += rwidth;
                y += DECREMENT;
                length -= DECREMENT;
            }
            Scene scene = new Scene(root, WIDTH, WIDTH / 2);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Rectangles");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}