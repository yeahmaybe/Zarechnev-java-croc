package ru.croc.task5;

import ru.croc.task1.Main;

public class Rectangle extends Figure {

        private Point leftCorner;
        private Point rightCorner;

        public Rectangle(Point leftCorner, Point rightCorner) {
                this.leftCorner = leftCorner;
                this.rightCorner = rightCorner;
        }

        public String toString() {
                return "R (" + leftCorner.getX() + ", " + leftCorner.getY() + "), (" + rightCorner.getX() + ", " + rightCorner.getY() + ")";
        }

        public boolean contains(Point point) {
                return (
                        leftCorner.getX() <= point.getX() &&
                        point.getX() <= rightCorner.getX() &&
                        leftCorner.getY() <= point.getY() &&
                        point.getY() <= rightCorner.getY()
                );
        }

        public void setLeftCorner(Point newLeftCorner) {
                leftCorner = newLeftCorner;
        }
        public void setRightCorner(Point newRightCorner) {
                rightCorner = newRightCorner;
        }

        public void move(int dx, int dy) {
                setLeftCorner(new Point(leftCorner.getX() + dx, leftCorner.getY() + dy) );
                setRightCorner(new Point(rightCorner.getX() + dx, rightCorner.getY() + dy) );
        }
}
