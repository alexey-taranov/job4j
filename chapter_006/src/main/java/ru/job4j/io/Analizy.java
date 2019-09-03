package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    private final List<String> result = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String str;
            String time = null;
            while (read.ready()) {
                str = read.readLine();
                if (str.contains("400") || str.contains("500")) {
                    time = str.substring(4);
                }
                if ((str.contains("200") || str.contains("300")) && time != null) {
                    result.add(String.join(";", time, str.substring(4)));
                    time = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToNewFile(target);
    }

    public void writeToNewFile(String source) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
            for (String timeToTime : result) {
                writer.write(timeToTime);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}