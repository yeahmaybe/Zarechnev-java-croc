package week4.task9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static void mergeLogs(String from) throws IOException {

        String to = "common.txt";
        File common = new File(to);
        if(common.createNewFile()) {} //создаем файл общего лога

        Object[] tree = Files.walk(Paths.get(from))
                .filter(t -> t.toString().matches(".+\\.log|.+\\.trace")).toArray();

        for(Object logPath: tree){



            File tmp = new File("tmp.txt");
            if(tmp.createNewFile()) {} //создаем временный файл

            String log = String.valueOf(logPath);
            //будем объединять логи с файлом общего лога во временный файл,
            //переименовывать его в файл общего лога, и так пока не закончатся логи

            try(BufferedReader fromOldLog = new BufferedReader(new FileReader(to));
                BufferedReader fromNewLog = new BufferedReader(new FileReader(log));
                BufferedWriter toTempLog = new BufferedWriter(new FileWriter(tmp))) {

                String newLine = fromNewLog.readLine(); //считываемый лог
                String oldLine = fromOldLog.readLine(); //общий лог

                while(newLine!=null && oldLine!=null) {
                    //время события из считываемого лога
                    long newTime = Long.parseLong(newLine.split(" ")[0]);
                    //время события из общего лога
                    long oldTime = Long.parseLong(oldLine.split(" ")[0]);

                    if(oldTime < newTime) {
                        toTempLog.write(oldLine + '\n');
                        oldLine = fromOldLog.readLine();
                    }
                    else {
                        toTempLog.write(newLine + '\n');
                        newLine = fromNewLog.readLine();
                    }
                }

                //дописываем оставшиеся события, если сортировать уже не надо
                while(newLine!=null) {
                    toTempLog.write(newLine +'\n');
                    newLine = fromNewLog.readLine();
                }
                while(oldLine!=null) {
                    toTempLog.write(oldLine +'\n');
                    oldLine = fromOldLog.readLine();
                }

                File oldLog = new File(to);
                toTempLog.flush();
                if(oldLog.delete() && tmp.renameTo(new File(to))) {}
            }
        }

        //выводим в консоль отсортированные события
        try(BufferedReader reader = new BufferedReader(new FileReader(to))) {
            String line = reader.readLine();
            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }

        if(new File(to).delete()) {}
    }

    public static void main(String[] args) throws IOException {
        mergeLogs(args[0]);
    }
}
