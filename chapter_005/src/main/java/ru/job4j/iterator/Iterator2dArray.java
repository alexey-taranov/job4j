package ru.job4j.iterator;

import java.util.Iterator;

public class Iterator2dArray implements Iterator {

    private final int[][] value;
    private int firstIndex = 0;
    private int secondIndex = 0;

    public Iterator2dArray(final int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return value.length > firstIndex;
    }

    @Override
    public Object next() {
        int result;
        if (secondIndex < value[firstIndex].length - 1) {
            result = value[firstIndex][secondIndex++];
        } else {
            result = value[firstIndex++][secondIndex];
            secondIndex = 0;
        }
        return result;
    }
}
