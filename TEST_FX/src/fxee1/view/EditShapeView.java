package fxee1.view;

import fxee1.controller.EditShapeController;
import fxee1.model.MCircle;
import fxee1.model.MEllipse;
import fxee1.model.MRectangle;
import fxee1.model.MShape;
import fxee1.model.MSquare;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditShapeView {
    private Stage primaryStage = null;
    private MShape shape = null;

    public EditShapeView(Stage primaryStage, MShape shape) {
        this.primaryStage = primaryStage;
        this.shape = shape;
    }

    public Stage create() {
        var view = new Stage();
        view.setTitle("Edit shape");
        var root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(8, 8, 8, 8));
        root.getColumnConstraints().add(new ColumnConstraints(180));
        root.getColumnConstraints().add(new ColumnConstraints(250));
        javafx.event.EventHandler<ActionEvent> submitAction = null;

        if (shape instanceof MCircle) {
            var label = new Label("Set new radius");
            root.add(label, 0, 0);
            var input = new TextArea(String.valueOf(((MCircle) shape).getRadius().getValue()));
            root.add(input, 0, 1);
            submitAction = new EditShapeController(shape, view, input);

        } else if (shape instanceof MEllipse) {
            var label = new Label("Set new axis1");
            root.add(label, 0, 0);
            var input = new TextArea(String.valueOf(((MEllipse) shape).getRadius1().getValue()));
            root.add(input, 0, 1);
            var label2 = new Label("Set new axis2");
            root.add(label2, 0, 2);
            var input2 = new TextArea(String.valueOf(((MEllipse) shape).getRadius2().getValue()));
            root.add(input2, 0, 3);
            submitAction = new EditShapeController(shape, view, input, input2);
        } else if (shape instanceof MSquare) {
            var label = new Label("Set new edgeLength");
            root.add(label, 0, 0);
            var input = new TextArea(String.valueOf(((MSquare) shape).getXDelta().getValue()));
            submitAction = new EditShapeController(shape, view, input);
            root.add(input, 0, 1);
        } else if (shape instanceof MRectangle) {
            var label = new Label("Set new width");
            root.add(label, 0, 0);
            var input = new TextArea(String.valueOf(((MRectangle) shape).getXDelta().getValue()));
            root.add(input, 0, 1);
            var label2 = new Label("Set new width");
            root.add(label2, 0, 2);
            var input2 = new TextArea(String.valueOf(((MRectangle) shape).getYDelta().getValue()));
            submitAction = new EditShapeController(shape, view, input, input2);

            root.add(input2, 0, 3);

        }
        var submit = new Button("submit");
        submit.setOnAction(submitAction);
        root.add(submit, 0, root.getRowCount() + 1);
        view.initModality(Modality.WINDOW_MODAL);
        view.initOwner(primaryStage);
        view.setScene(new Scene(root, 480, 400));
        view.setAlwaysOnTop(true);
        return view;
    }

}
