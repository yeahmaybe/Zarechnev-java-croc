package week2.task5;

public abstract class Figure implements Movable{

    @Override
    public abstract String toString();
    public abstract boolean contains(Point point);

    public abstract void move(int dx, int dy);
}
