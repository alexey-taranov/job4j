package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    SimpleQueue<Integer> queue = new SimpleQueue();

    @Test
    public void whenAddFourElementsThenPollResultOneAndTwo() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
    }

    @Test
    public void whenAddFourElementsThenPollNotOrderResultOneAndTwo() {
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(1));
        queue.push(3);
        assertThat(queue.poll(), is(2));
        queue.push(4);
        assertThat(queue.poll(), is(3));
    }
}
