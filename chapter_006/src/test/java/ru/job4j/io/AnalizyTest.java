package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenInputSourceThenOutputTarget() throws IOException {
        Analizy analizy = new Analizy();
        analizy.unavailable("c:/projects/job4j/server.log", "c:/projects/job4j/unavailable.csv");
        BufferedReader reader = new BufferedReader(new FileReader("c:/projects/job4j/unavailable.csv"));
        assertThat(reader.readLine(), is("10:58:01;10:59:01"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02"));
    }
}
