package ru.job4j.set;

import ru.job4j.list.DynamicList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private DynamicList<E> simpleSet;
    private int capacity = 0;

    public SimpleSet(int size) {
        this.simpleSet = new DynamicList<>(size);
    }

    public void add(E e) {
        if (!simpleSet.compareValue(e)) {
            simpleSet.add(e);
            capacity++;
        }
    }

    public int getCapacity()  {
        return this.capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleSet.iterator();
    }
}
