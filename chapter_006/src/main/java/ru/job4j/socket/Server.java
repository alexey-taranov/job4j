package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket;

    public Server(final Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept()) {
            Server server = new Server(socket);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
                out.println();
            } else if (!"exit".equals(ask)) {
                out.println("I dont understand you");
                out.println();
            }
        } while (!"exit".equals(ask));
    }
}
