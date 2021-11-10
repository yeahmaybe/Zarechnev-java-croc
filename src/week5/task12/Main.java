package week5.task12;

import javax.print.attribute.standard.PrintQuality;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    public static void main(String[] args) {

        int threadNum = Integer.parseInt(args[0]);
        String hash = args[1];
        //hash = hashPassword("acfffff");

        Thread[] thread = new Thread[threadNum];
        String finalHash = hash;

        Runnable r = new Runnable() {
            private final Object lock = new Object();
            volatile int[] password = new int[7];
            volatile boolean notFound = true;

            void nextPassword(int index) {
                    if (index >= 0) {
                        if (password[index] == 25) {
                            password[index] = 0;
                            nextPassword(index - 1);
                        } else {
                            password[index]++;
                        }
                    }
            
            }

            int[] getPassword() {
                    return password;
            }

            boolean notFound() {
                synchronized (lock) {
                    return notFound;
                }
            }

            @Override
            public void run() {
                for (int i = 0; i < 7; ++i)
                    password[i] = 0;

                while (notFound()) {

                        String candidatePass = "";
                        for (int i = 0; i < 7; ++i) {
                            candidatePass += (char) (getPassword()[i] + (int) ('a'));
                        }

                            //System.out.println(candidatePass + " " + Thread.currentThread().getName());

                        if (hashPassword(candidatePass).equals(finalHash)) {
                            synchronized (lock) {
                                notFound = false;
                            }
                            System.out.println(candidatePass);
                            Thread.currentThread().interrupt();
                        }
                        synchronized (lock) {
                            //итерация пароля
                            nextPassword(6);
                        }
                    }
                }
        };

        for(int i=0; i<threadNum; ++i) {
            thread[i] = new Thread(r);
            thread[i].start();
        }
    }
}
