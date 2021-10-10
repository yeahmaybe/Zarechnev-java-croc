package ru.croc.task3;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static int[] numbers;

    static void swap( int fst, int snd) {
        int tmp = numbers[fst];
        numbers[fst] = numbers[snd];
        numbers[snd] = tmp;
    }

    static void exec() {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.asList(scanner.nextLine().split(" "));
        numbers = input.stream().mapToInt(Integer::parseInt).toArray();

        int max = numbers[0], min = numbers[0], minIndex = 0, maxIndex = 0;

        for(int i=0; i < numbers.length; ++i) {
            if(min > numbers[i]) {
                min = numbers[i];
                minIndex = i;
            }
            if(max < numbers[i]) {
                max = numbers[i];
                maxIndex = i;
            }
        }

        if(numbers[0] != min)
            swap(0, minIndex);
        if(numbers[numbers.length-1] != max)
            swap(numbers.length-1, maxIndex);

        for(int num: numbers)
            System.out.print(num + " ");
    }

    public static void main(String[] args) {
        exec();
    }
}
