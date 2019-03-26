package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort array = new BubbleSort();
        int[] input = new int[] {1, 4, 2, 3, 7, 8, 5, 6, 9};
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = array.sort(input);
        assertThat(result, is(expect));
    }
}