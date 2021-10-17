package ru.croc.task4;

public class Rectangle extends Figure {

        private final Point leftCorner;
        private final Point rightCorner;

        public Rectangle(Point leftCorner, Point rightCorner) {
                this.leftCorner = leftCorner;
                this.rightCorner = rightCorner;
        }

        public String toString() {
                return "R (" + leftCorner.getX() + ", " + leftCorner.getY() + "), (" + rightCorner.getX() + ", " + rightCorner.getY() + ")";
        }
}
