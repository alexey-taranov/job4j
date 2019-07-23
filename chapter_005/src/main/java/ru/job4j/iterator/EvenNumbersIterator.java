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
        boolean res = false;
        for (int i = firstIndex; i < value.length; i++) {
            if (value[i] % 2 == 0) {
               res = true;
               firstIndex = i;
               break;
            }
        }
        return res;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return value[firstIndex++];
    }
}
