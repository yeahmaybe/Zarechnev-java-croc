package week5.task11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lot lot = new Lot();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Scanner scan = new Scanner(System.in);
                for(int i = 0; i < 5; i++) {

                    //обновление ставки
                    lot.updatePrice(
                            scan.nextDouble(), //новая цена
                            scan.nextLine() //новый лидер
                    );

                    System.out.println(lot.getLeader());
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}
