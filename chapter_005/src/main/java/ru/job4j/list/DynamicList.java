package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public DynamicList(int size) {
        this.container = new Object[size];
    }

    public void add(E value) {
        expandArray();
        container[index] = value;
        this.index++;
        this.modCount++;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public void expandArray() {
        if (index >= container.length) {
            Object[] newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                return iterIndex < index;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[iterIndex++];
            }
        };
    }
}
