package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private final InputStream source;
    private List<String> result = new ArrayList<>();
    private List<String> log = new ArrayList<>();
    private boolean ask = true;

    public ConsoleChat(final InputStream source) {
        this.source = source;
    }

    public void convert(InputStream source) {
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(source));
            Scanner scanner = new Scanner(read);
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chat() {
        convert(this.source);
        boolean finish;
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String question = null;
        do {
            try {
                question = scan.readLine();
            } catch (IOException e) {
            e.printStackTrace();
            }
            finish = analizeQuestion(question);
        } while (finish);
    }

    public boolean analizeQuestion(String question) {
        boolean rst = true;
        saveInLog(question);
        if ("стоп".equals(question)) {
            this.ask = false;
        } else if ("продолжить".equals(question)) {
            this.ask = true;
        } else if ("закончить".equals(question)) {
            this.ask = false;
            saveLog();
            rst = false;
        }
        if (this.ask) {
            String answer = getAnswer();
            System.out.println(answer);
        }
        return rst;
    }

    public String getAnswer() {
        String random = result.get(new Random().nextInt(result.size()));
        saveInLog(random);
        return random;
    }

    public void saveInLog(String string) {
        log.add(string);
    }

    public void saveLog() {
        try (BufferedWriter txtLog = new BufferedWriter(new FileWriter("txtLog.txt"))) {
            for (String string : this.log) {
                txtLog.write(string + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InputStream in = ConsoleChat.class.getResourceAsStream("/randWords.txt");
        ConsoleChat chat = new ConsoleChat(in);
        chat.chat();
    }
}
