package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedList<E> implements Iterable<E> {

    private int size;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        if (this.size == 0) {
            this.first = newLink;
            newLink.prev = null;
        } else {
            newLink.prev = this.last;
            this.last.next = newLink;
        }
        newLink.next = null;
        this.last = newLink;
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E deleteLastElement() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> rst = this.last;
        this.last = rst.prev;
        if (this.size != 1) {
            this.last.next = null;
        }
        this.size--;
        this.modCount++;
        return rst.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int iterIndex = 0;
            private Node<E> iterNode = first;

            @Override
            public boolean hasNext() {
                return iterIndex < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rst = iterNode.data;
                iterNode = iterNode.next;
                iterIndex++;
                return rst;
            }
        };
    }
}
