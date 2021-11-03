package week4.task8;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    static long countWords(String file) {

        long wordsNum = 0;
        try (BufferedReader in  = new BufferedReader(new FileReader(file))) {
            while(in.ready()) {
                String line = in.readLine();
                wordsNum += Arrays.stream(line.split(" "))
                        .filter(elem -> !Objects.equals(elem, ""))
                        .count();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wordsNum;
    }

    public static void main(String[] args) {
        System.out.println(countWords(args[0]));
    }
}
