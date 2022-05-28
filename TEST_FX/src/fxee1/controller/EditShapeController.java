package fxee1.controller;

import fxee1.model.MCircle;
import fxee1.model.MEllipse;
import fxee1.model.MRectangle;
import fxee1.model.MShape;
import fxee1.model.MSquare;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditShapeController implements EventHandler<ActionEvent> {

    MShape shape = null;
    Stage view = null;
    TextArea[] values = null;

    public EditShapeController(MShape shape, Stage view, TextArea... values) {
        this.shape = shape;
        this.view = view;
        this.values = values;
    }

    @Override
    public void handle(ActionEvent arg0) {
        if (shape instanceof MCircle) {
            ((MCircle) shape).setRadius(Double.parseDouble(values[0].getText()));

        } else if (shape instanceof MEllipse) {
            ((MEllipse) shape).setRadius1(Double.parseDouble(values[0].getText()));
            ((MEllipse) shape).setRadius2(Double.parseDouble(values[1].getText()));

        } else if (shape instanceof MSquare) {
            ((MSquare) shape).setYDelta(Double.parseDouble(values[0].getText()));

        } else if (shape instanceof MRectangle) {
            ((MRectangle) shape).setXDelta(Double.parseDouble(values[0].getText()));
            ((MRectangle) shape).setYDelta(Double.parseDouble(values[1].getText()));

        }
        view.close();

    }

}