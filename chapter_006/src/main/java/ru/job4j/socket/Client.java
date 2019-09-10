package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String ip;
    private final int servPort;

    public Client(String ip, int port) {
        this.ip = ip;
        this.servPort = port;
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        String str;
        Socket socket = new Socket(InetAddress.getByName(ip), servPort);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        do {
            str = console.nextLine();
            out.println(str);
            String answer = in.readLine();
            while (!answer.isEmpty()) {
                System.out.println(answer);
            }
        } while (!str.equals("exit"));
    }
}
