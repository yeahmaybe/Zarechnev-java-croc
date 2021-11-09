package week3.task7;

public class ChessPosition {
    int x;
    int y;

    // конструктор с int на входе
    public ChessPosition(int x, int y) throws IllegalPositionException {

        try { //проверка на допустимость координат
            if ((0 > x) || (x > 7) || (0 > y) || (y > 7)) {
                throw new IllegalPositionException();
            }
        } finally {
            this.x = x;
            this.y = y;
        }

    }


    @Override
    public String toString() {
        return (char)(96+x) + Integer.toString(y+1);
    }

    static int parse(char x, String type) {
        int res;
        switch(type) {
            case("column"):
                res = (int)(x) - 96;
                break;
            case("row"):
                res = Integer.parseInt(x+"")-1;
                break;
            default:
                res = -1;
        }
        return res;
    }
}
