package week3.task7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static ChessPosition parse(String position) throws IllegalPositionException {
        if(position.length() != 2)
            throw new IllegalPositionException();

        return new ChessPosition(
            ChessPosition.parse(position.charAt(0), "column"),
            ChessPosition.parse(position.charAt(1), "row")
        );
    }

    static boolean moveIsPossible(ChessPosition A, ChessPosition B) {
        // произведение координат хода равно 2 <=>
        // <=> ход - одна из комбинаций {+2, +1}, {+2, -1}, ...
        if(Math.abs((A.x.getNum() - B.x.getNum())*(A.y.getNum() - B.y.getNum())) == 2)
            return true;
        return false;
    }

    static boolean canHorseWalkThatWay() throws IllegalPositionException {
        Scanner scanner = new Scanner(System.in);

        String[] way = scanner.nextLine().split(" ");
        ChessPosition prev = parse(way[0]);
        way[0] = null;

        for (String nextPos: way) {
            if(nextPos == null)
                continue;

            ChessPosition next = parse(nextPos);
            try {
                if(!moveIsPossible(prev, next))
                    throw new IllegalMoveException(prev, next);
            }
            catch(IllegalMoveException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
            prev = next;
        }

        System.out.println("OK");
        scanner.close();
        return true;
    }

    public static void main(String[] args) throws IllegalPositionException {

        canHorseWalkThatWay();
    }
}
