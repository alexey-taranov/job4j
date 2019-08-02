package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddThreeElementsThenCapacityEqualsThree() {
        SimpleSet<Integer> set = new SimpleSet<>(10);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        assertThat(set.getCapacity(), is(3));
    }
}
