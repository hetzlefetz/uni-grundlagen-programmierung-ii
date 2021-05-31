package fxee1.model;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * This class represents a circle. A circle is a shape with a radius.
 * 
 * @author Gert Veltink, updated Agathe Merceron
 *
 */

public class MCircle extends MShape {

    private SimpleDoubleProperty radius;

    /**
     * Constructs a circle with the given origin and the given radius
     * 
     * @param x      the x-coordinate of the shape's origin
     * @param y      the y-coordinate of the shape's origin
     * @param radius Radius of this circle
     * 
     */
    public MCircle(double x, double y, double radius) {
        super(x, y);
        this.radius = new SimpleDoubleProperty(radius);
    }

    public SimpleDoubleProperty getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius.setValue(value);
    }

    /**
     * calculate the area of a circle.
     * 
     * @return the area of the circle
     */
    @Override
    public double area() {
        return (Math.PI * (this.radius.getValue() * this.radius.getValue()));
    }

    /**
     * calculate the circumference of a circle.
     * 
     * @return the circumference of the circle
     */
    @Override
    public double circumference() {
        return (2 * Math.PI * this.radius.getValue());
    }

    /**
     * constructs a textual representation of this circle.
     * 
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Circle with origin: " + origin() + " and radius: " + this.radius;
    }

}
