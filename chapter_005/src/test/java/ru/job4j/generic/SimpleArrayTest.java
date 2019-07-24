package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(7);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
    }

    @Test
    public void whenElementAdd() {
        simpleArray.add(6);
        assertThat(simpleArray.get(5), is(6));
    }

    @Test
    public void whenElementSet() {
        simpleArray.set(3, 33);
        assertThat(simpleArray.get(3), is(33));
    }

    @Test
    public void whenElementRemove() {
        simpleArray.remove(0);
        assertThat(simpleArray.get(1), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddMoreElements() {
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
    }

    @Test
    public void whenAllNumbersIterate() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }
}
