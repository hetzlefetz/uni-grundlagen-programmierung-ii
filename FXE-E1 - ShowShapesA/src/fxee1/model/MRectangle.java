package fxee1.model;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * represents a Rectangle. A Rectangle is a Shape with a length and a width.
 * 
 * @author Gert Veltink, updated Agathe Merceron
 *
 */

public class MRectangle extends MShape {

    private SimpleDoubleProperty xDelta;

    private SimpleDoubleProperty yDelta;

    /**
     * constructs a rectangle object
     * 
     * @param xOrigin the x-coordinate of the shape's origin
     * @param yOrigin the y-coordinate of the shape's origin
     * @param xDelta  half of the length
     * @param yDelta  half of the width
     * 
     */

    public MRectangle(double xOrigin, double yOrigin, double xDelta, double yDelta) {
        super(xOrigin, yOrigin);
        this.xDelta = new SimpleDoubleProperty(xDelta);
        this.yDelta = new SimpleDoubleProperty(yDelta);
    }

    /**
     * returns half the length of the rectangle
     * 
     * @return half the length
     */

    public SimpleDoubleProperty getXDelta() {
        return xDelta;
    }

    public void setXDelta(double value) {
        this.xDelta.setValue(value);
    }

    /**
     * returns half the width of the rectangle
     * 
     * @return half the width
     */

    public SimpleDoubleProperty getYDelta() {
        return yDelta;
    }

    public void setYDelta(double value) {
        this.yDelta.setValue(value);
    }

    /**
     * calculate the area of this rectangle.
     * 
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        return (2 * this.xDelta.getValue()) * (2 * this.yDelta.getValue());
    }

    /**
     * calculate the circumference of this rectangle.
     * 
     * @return the circumference of the rectangle
     */
    @Override
    public double circumference() {
        return (4 * this.xDelta.getValue()) + (4 * this.yDelta.getValue());
    }

    /**
     * constructs a textual representation of the object.
     * 
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Rectangle with origin: " + origin() + ", xDelta: " + this.xDelta + ", yDelta: ";
    }

}
