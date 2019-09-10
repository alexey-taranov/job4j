package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskExitThenReturnEmpty() throws IOException {
        testServer("exit", "");
    }

    @Test
    public void whenAskHelloThenReturnTextFromServer() throws IOException {
        testServer(Joiner.on(LN).join("hello", "exit"),
                Joiner.on(LN).join("Hello, dear friend, I'm a oracle.", ""));
    }

    @Test
    public void whenAskDifficultQuestionThenReturnAnswerFromServer() throws IOException {
        testServer(Joiner.on(LN).join("Hi", "exit"), Joiner.on(LN).join("I dont understand you", ""));
    }

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }
}