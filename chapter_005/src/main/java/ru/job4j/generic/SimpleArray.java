package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private int size;
    private Object[] array;
    private int ind = 0;

    public SimpleArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public void add(T model) {
        if (ind < size) {
            array[ind++] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index, T model) {
        if (index <= ind) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index <= ind) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            ind--;
        }
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                return iterIndex < ind;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[iterIndex++];
            }
        };
    }
}
