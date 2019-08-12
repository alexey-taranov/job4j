package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry> {

    private Entry[] container;
    private int capacity = 16;
    private int size;
    private final float loadFactor = 0.75f;

    public SimpleHashMap() {
        container = new Entry[this.capacity];
    }

    public boolean insert(K key, V value) {
        checkSize();
        int index = indexForValue(key);
        if (container[index] == null) {
            container[index] = new Entry(key, value);
            size++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int index = indexForValue(key);
        if (container[index] == null) {
            return null;
        }
        return (V) container[index].getValue();
    }

    public boolean delete(K key) {
        int index = indexForValue(key);
        if (container[index] != null) {
            container[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private void checkSize() {
        if (size > capacity * loadFactor) {
            capacity *= 2;
            Entry[] newContainer = new Entry[capacity];
            for (Entry entry : container) {
                if (entry != null) {
                    newContainer[indexForValue((K) entry.getKey())] = entry;
                }
            }
            container = newContainer;
        }
    }

    private int indexForValue(K key) {
        return key.hashCode() & (capacity - 1);
    }

    public int getSize() {
        return size;
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<>() {
            private int iterIndex = 0;

            @Override
            public boolean hasNext() {
                int count = iterIndex;
                while (count < container.length) {
                    if (container[count] != null) {
                        iterIndex = count;
                        return true;
                    }
                    count++;
                }
                return false;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[iterIndex++];
            }
        };
    }
}