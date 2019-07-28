package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicListTest {

    private DynamicList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddFourElementsThenUseGetThreeResultFour() {
        list.add(4);
        assertThat(list.get(3), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddThreeElementsAfterIteratorThenException() {
        Iterator<Integer> it = list.iterator();
        it.next();
        list.add(6);
        it.next();
    }
}
