package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void when1to10() {
       Counter counter = new Counter();
       int result = counter.add(0, 10);
       assertThat(result, is(30));
    }
}
