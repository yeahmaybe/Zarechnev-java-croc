package week3.task7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ChessPosition parse(String position) throws IllegalPositionException {
        ChessPosition pos;
        try {
            pos = new ChessPosition(
                    ChessPosition.parse(position.charAt(0), "column"),
                    ChessPosition.parse(position.charAt(1), "row")
            );
        } catch (Exception e) {
            pos = null;
            e.printStackTrace();
        }
        return pos;
    }

    static boolean moveIsPossible(ChessPosition A, ChessPosition B) {
        // произведение координат хода равно 2 <=>
        // <=> ход - одна из комбинаций {+2, +1}, {+2, -1}, ...
        if(Math.abs((A.x - B.x)*(A.y - B.y)) == 2)
            return true;
        return false;
    }

    static boolean canHorseWalkThatWay() {
        try(Scanner scanner = new Scanner(System.in)) {

            String[] originalWay = scanner.nextLine().split(" ");

            ChessPosition prev;
            prev = parse(originalWay[0]);

            String[] way = new String[originalWay.length - 1];
            System.arraycopy(originalWay, 1, way, 0, originalWay.length - 1);

            for (String nextPos : way) {
                ChessPosition next;

                next = parse(nextPos);

                if (!moveIsPossible(prev, next))
                    throw new IllegalMoveException(prev, next);
                prev = next;
            }

            System.out.println("OK");
            return true;
        }
        catch(IllegalPositionException ex) {
            ex.getMessage();
        }
        catch(IllegalMoveException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            return false;
        }

    }

    public static void main(String[] args) throws IllegalPositionException {

        canHorseWalkThatWay();
    }
}
