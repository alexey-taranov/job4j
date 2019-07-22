package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] value;
    private int firstIndex = 0;

    public EvenNumbersIterator(int[] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {

        for (int i = firstIndex; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (value[firstIndex] % 2 != 0) {
            firstIndex++;
        }
        return value[firstIndex++];
    }
}
