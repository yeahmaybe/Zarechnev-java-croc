package week3.task7;

public class ChessPosition {
    ColumnCoordinate x;
    RowCoordinate y;

    // конструктор с int на входе
    public ChessPosition(int x, int y) throws IllegalPositionException {

        try { //проверка на допустимость координат
            if( (0 > x) || (x > 7) || (0 > y) || (y > 7) ) {
                throw new IllegalPositionException();
            }

            // тело конструктора
            this.x = new ColumnCoordinate(x);
            this.y = new RowCoordinate(y);
        }
        // обработка ошибки
        catch(IllegalPositionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //конструктор с Coordinate на входе
    public ChessPosition(Coordinate x, Coordinate y) {
        try {
            //проверка на допустимость координат
            if( (0 > x.getNum()) || (x.getNum() > 7) || (0 > y.getNum()) || (y.getNum() > 7) ) {
                throw new IllegalPositionException();
            }

            // тело конструктора
            this.x = new ColumnCoordinate(x.getNum());
            this.y = new RowCoordinate(y.getNum());
        }
        // обработка ошибки
        catch(IllegalPositionException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return x.toString() + y.toString();
    }

    public static Coordinate parse(char x, String type) {
        return switch (type) {
            case ("column") -> ColumnCoordinate.parse(x);
            case ("row") -> RowCoordinate.parse(x);
            default -> null;
        };
    }
}
