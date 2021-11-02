package week3.task7;

public class ColumnCoordinate extends CoordinateCreator {
    int x;
    char name;
    ColumnCoordinate(int x) {
        this.x = x;
        this.name = (char)(97+x);
    }

    @Override
    public String toString() {
        return name+"";
    }

    public static ColumnCoordinate parse(char c) {
        return new ColumnCoordinate((int)c-97);
    }

    @Override
    public int getNum() {
        return x;
    }
}
