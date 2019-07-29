package ru.job4j.list;

public class SimpleStack<T> {

    private DynamicLinkedList<T> simpleStack = new DynamicLinkedList<>();

    public T poll() {
        return simpleStack.deleteLastElement();
    }

    public void push(T value) {
        simpleStack.add(value);
    }

    public DynamicLinkedList<T> getSimpleStack() {
        return simpleStack;
    }
}
