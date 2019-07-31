package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    SimpleQueue queue = new SimpleQueue();

    @Test
    public void whenAddFourElementsThenUseGetZeroAndOneResultThreeAndFour() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.poll();
        queue.poll();
        assertThat(queue.getSimpleStack().get(0), is(3));
        assertThat(queue.getSimpleStack().get(1), is(4));
    }
}
