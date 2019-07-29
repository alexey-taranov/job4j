package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    SimpleStack stack = new SimpleStack();

    @Test
    public void whenAddFourElementsThenUseGetThreeResultFour() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.poll();
        stack.poll();
        assertThat(stack.getSimpleStack().get(0), is(1));
    }
}
