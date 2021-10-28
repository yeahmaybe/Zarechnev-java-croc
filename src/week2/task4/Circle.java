package week2.task4;

public class Circle extends Figure {

    private final double radius;
    private final Point center;

    public Circle(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    public String toString() {

        return "C (" + center.getX() + ", " + center.getY() + "), " + radius;
    }
}
