package ru.job4j.loop;

import org.hamcrest.Matchers;
import org.junit.Test;


import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCount5() {
        Factorial factorial  = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, Matchers.is(120));
    }

    @Test
    public void whenCount0() {
        Factorial factorial  = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, Matchers.is(1));
    }
}
