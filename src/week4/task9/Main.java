package week4.task9;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static void mergeLogs(String from, String to) throws IOException {

        Object[] tree = Files.walk(Paths.get(from))
                .filter(t -> t.toString().matches(".+\\.log|.+\\.trace")).toArray();

        for(Object logPath: tree){
            String log = String.valueOf(logPath);
            File tmp = new File("tmp.txt");
            if(tmp.createNewFile()) {};

            try(BufferedReader fromOldLog = new BufferedReader(new FileReader(to));
                BufferedReader fromNewLog = new BufferedReader(new FileReader(log));
                BufferedWriter toTempLog = new BufferedWriter(new FileWriter(tmp))) {

                String newLine = fromNewLog.readLine();
                String oldLine = fromOldLog.readLine();

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

                //дописываем оставшиеся события
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
    }

    public static void main(String[] args) throws IOException {
        mergeLogs("logs", "logs.txt");
    }
}
