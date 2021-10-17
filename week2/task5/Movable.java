package ru.croc.task5;

public interface Movable {

    void move(int dx, int dy);

    boolean contains(Point point);
    String toString();
}
