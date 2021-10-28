package week2.task5;

public class Circle extends Figure {

    private double radius;
    private Point center;

    public Circle(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    public String toString() {

        return "C (" + center.getX() + ", " + center.getY() + "), " + radius;
    }

    public boolean contains(Point point) {

        double squaredDistance =
                (point.getX() - center.getX()) * (point.getX() - center.getX()) +
                        (point.getY() - center.getY()) * (point.getY() - center.getY());

        return squaredDistance <= radius * radius;
    }

    public void setCenter(Point newCenter) {
        center = newCenter;
    }

    public void move(int dx, int dy) {
        setCenter( new Point(center.getX() + dx, center.getY() + dy) );
    }
}
