package week3.task7;

public class RowCoordinate extends CoordinateCreator {
    int y;
    RowCoordinate(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(y+1);
    }

    public static RowCoordinate parse(char c) {
        return new RowCoordinate((int)c-48-1);
    }

    @Override
    public int getNum() {
        return y;
    }
}
