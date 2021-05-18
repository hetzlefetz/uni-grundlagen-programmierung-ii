package fxge2.model;

public class MEllipse extends MShape {

    private double radius1;

    private double radius2;

    public MEllipse(double x, double y, double radius1, double radius2) {
        super(x, y);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public double getRadius1() {
        return radius1;
    }

    public void setRadius1(double _radius1) {
        this.radius1 = _radius1;
    }

    public double getRadius2() {
        return radius2;
    }

    public void setRadius2(double _radius2) {
        this.radius2 = _radius2;
    }

    @Override
    public double area() {
        return Math.PI * radius1 * radius2;
    }
}
