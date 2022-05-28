package fxee1.model;

import javafx.beans.property.SimpleDoubleProperty;

public class MEllipse extends MShape {

    private SimpleDoubleProperty radius1;

    private SimpleDoubleProperty radius2;

    public MEllipse(double x, double y, double radius1, double radius2) {
        super(x, y);
        this.radius1 = new SimpleDoubleProperty(radius1);
        this.radius2 = new SimpleDoubleProperty(radius2);
    }

    public SimpleDoubleProperty getRadius1() {
        return radius1;
    }

    public void setRadius1(double _radius1) {
        this.radius1.setValue(_radius1);
    }

    public SimpleDoubleProperty getRadius2() {
        return radius2;
    }

    public void setRadius2(double _radius2) {
        this.radius2.setValue(_radius2);
    }

    @Override
    public double area() {
        return Math.PI * radius1.getValue() * radius2.getValue();
    }
}
