package week4.task10;

import com.sun.source.tree.BreakTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {
    static void sortLogs(String from, String to) throws IOException {

        File calls = new File(to);
        if (calls.createNewFile()) {}

        try (BufferedReader fromOldLog = new BufferedReader(new FileReader(from))) {
            String oldLine = fromOldLog.readLine();

            while (oldLine != null) {

                File tmp = new File("tmp.txt");
                if(tmp.createNewFile()) {}

                try(BufferedReader fromCalls = new BufferedReader(new FileReader(to));
                    BufferedWriter toTemp = new BufferedWriter(new FileWriter(tmp))) {

                    String newLine = fromCalls.readLine();
                    if(newLine == null) {
                        toTemp.write(oldLine + '\n');
                    }
                    else {
                        boolean inserted = false;
                        while (newLine != null) {
                            long newTime = Long.parseLong(newLine.split(" ")[0]);
                            long oldTime = Long.parseLong(oldLine.split(" ")[0]);

                            if (oldTime < newTime) {
                                toTemp.write(oldLine + '\n');
                                inserted = true;
                                while (newLine != null) {
                                    toTemp.write(newLine + '\n');
                                    newLine = fromCalls.readLine();
                                }
                                break;
                            } else {
                                toTemp.write(newLine + '\n');
                                newLine = fromCalls.readLine();
                            }
                        }
                        if (!inserted) {
                            toTemp.write(oldLine + '\n');
                        }
                    }

                    oldLine = fromOldLog.readLine();
                    toTemp.flush();
                    if(new File(to).delete() && tmp.renameTo(new File(to))) {};
                }
            }
        }
    }

    static void transformLog(String from, String to) throws IOException {
        File tmp = new File("tmp.txt");
        if(tmp.createNewFile()) {};

        try(BufferedReader fromLog = new BufferedReader(new FileReader(from));
            BufferedWriter toTempLog = new BufferedWriter(new FileWriter(tmp))) {

            String line = fromLog.readLine();

            while(line!=null) {
                String start = line.split(",")[0];
                String end = line.split(",")[1];

                toTempLog.write(start + " " + "start\n");
                toTempLog.write(end + " " + "end\n");

                line = fromLog.readLine();
            }
        }
        if(tmp.renameTo(new File(to))){};
    }

    static long countCalls(String calls) throws IOException {
        long counter = 0;
        long maximum = 0;

        try(BufferedReader fromList = new BufferedReader(new FileReader(calls))) {
            String call = fromList.readLine();

            while(call != null) {
                String callEvent = call.split(" ")[1];

                if (Objects.equals(callEvent, "start")) {
                    counter += 1;
                    maximum = Math.max(maximum, counter);
                }
                if (Objects.equals(callEvent, "end")) {
                    counter -= 1;
                }

                call = fromList.readLine();
            }
        }
        return maximum;
    }

    public static void main(String[] args) throws IOException {

        String base = "logs.txt"; // база звонков

        transformLog(base, "old.txt"); //форматируем звонки в список событий
        sortLogs("old.txt", "calls.txt"); //сортируем список событий по времени
        System.out.println(countCalls("calls.txt")); // подсчитываем максимальное количество звонков

        // удаляем вспомогательные файлы
        File file = new File("old.txt");
        if(file.delete()) {};

        file = new File("calls.txt");
        if(file.delete()) {};

    }

}
