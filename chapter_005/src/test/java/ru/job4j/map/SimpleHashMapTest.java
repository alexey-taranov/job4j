package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    SimpleHashMap<Integer, String> map;

    @Before
    public void start() {
        map = new SimpleHashMap<>();
        map.insert(0, "Alex");
        map.insert(1, "Misha");
        map.insert(2, "Nikita");
    }

    @Test
    public void whenAddElement() {
        map.insert(3, "Vova");
        assertThat(map.getSize(), is(4));
    }

    @Test
    public void whenDeleteElement() {
        map.delete(2);
        assertThat(map.getSize(), is(2));
    }

    @Test
    public void whenGetElement() {
        assertThat(map.get(0), is("Alex"));
    }

    @Test
    public void whenGetElementWithIncorrectKey() {
        assertThat(map.get(5), is((String) null));
    }

    @Test
    public void whenAddElementWithSameKey() {
        assertThat(map.insert(1, "Maksim"), is(false));
    }

    @Test
    public void whenAllElementsIterate() {
        Iterator<SimpleHashMap.Entry> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Alex"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Misha"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("Nikita"));
        assertThat(iterator.hasNext(), is(false));
    }
}