package ru.croc.task2;

import java.util.Scanner;

public class Main {

    public static String[] measures = new String[] {"B", "KB", "MB", "GB", "TB"};

    public static void getReformat(double bytes) {
        int measure = 0;
        while( bytes > 1024 ) {
            bytes /= 1024.0;
            measure += 1;
        }
        System.out.println(String.format("%.1f", bytes) + " " + measures[measure]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double bytes = scanner.nextDouble();
        getReformat(bytes);
    }
}
