package week1.task3;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] numbers;

    static void swap(int fst, int snd) {
        int tmp = numbers[fst];
        numbers[fst] = numbers[snd];
        numbers[snd] = tmp;
    }

    static void replaceMin(int[] numbers){

        int min = numbers[0], minIndex = 0;

        for(int i=0; i < numbers.length; ++i) {
            if(min > numbers[i]) {
                min = numbers[i];
                minIndex = i;
            }
        }
        swap(0, minIndex);
    }
    static void replaceMax(int[] numbers){

        int max = numbers[0], maxIndex = 0;

        for(int i=0; i < numbers.length; ++i) {
            if(max < numbers[i]) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        swap(numbers.length-1, maxIndex);
    }

    static void output(int[] numbers) {

        for(int num: numbers)
            System.out.print(num + " ");
    }

    static void exec() {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.asList(scanner.nextLine().split(" "));
        numbers = input.stream().mapToInt(Integer::parseInt).toArray();

        replaceMin(numbers);
        replaceMax(numbers);

        output(numbers);
    }

    public static void main(String[] args) {
        exec();
    }
}