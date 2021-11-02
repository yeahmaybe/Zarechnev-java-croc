package week3.task7;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(ChessPosition a, ChessPosition b) {
        super("Конь так не ходит: " + a +" -> " + b);
    }
}
