package ru.croc.task1;

import java.util.Scanner;

public class Main {
    public static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


    public static class Triangle {
        Point A;
        Point B;
        Point C;

        Triangle(Point A, Point B, Point C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }

        public double countSquare() {
            Point AB = new Point(
                    this.B.x - this.A.x, // х-координата вектора
                    this.B.y - this.A.y  // y-координата
            );
            Point AC = new Point(
                    this.C.x - this.A.x, // х-координата вектора
                    this.C.y - this.A.y  // y-координата
            );

            return pseudoVectorProduct(AB, AC) / 2.0;
        }
    }


    public static double pseudoVectorProduct(Point AB, Point AC) {
        return Math.abs(AB.x * AC.y - AB.y * AC.x);
    }

    public static void getSquare() {

        Point[] points = new Point[3];
        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<3; ++i) {
            System.out.print("Введите координату х вершины №" + (i+1) + ": ");
            double x = scanner.nextDouble();

            System.out.print("Введите координату y вершины №" + (i+1) + ": ");
            double y = scanner.nextDouble();

            points[i] = new Point(x,y);
        }
        Triangle triangle = new Triangle(points[0], points[1], points[2]);
        System.out.println(triangle.countSquare());
    }

    public static void main(String[] args) {
            getSquare();
    }
}
