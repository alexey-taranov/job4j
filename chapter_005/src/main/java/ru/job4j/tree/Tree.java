package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private final Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rst = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent() && findBy(child).isEmpty()) {
            parentNode.get().add(new Node<>(child));
            rst = true;
        }
        return rst;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean rst = true;
        Queue<Node<E>> treeIterator = new LinkedList<>();
        treeIterator.offer(root);
        while (!treeIterator.isEmpty()) {
            Node<E> elem = treeIterator.poll();
            int count = 0;
            for (Node<E> child : elem.leaves()) {
                treeIterator.offer(child);
                count++;
            }
            if (count > 2) {
                rst = false;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> listIterator = new LinkedList<>();
        listIterator.offer(this.root);
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !listIterator.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = listIterator.poll();
                for (Node<E> child : result.leaves()) {
                    listIterator.offer(child);
                }
                return result.getValue();
            }
        };
    }
}
