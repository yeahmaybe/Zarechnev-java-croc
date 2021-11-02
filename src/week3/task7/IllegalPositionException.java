package week3.task7;

public class IllegalPositionException extends Exception {
    public IllegalPositionException() {
        super("Недопустимые координаты позиции");
    }
}
