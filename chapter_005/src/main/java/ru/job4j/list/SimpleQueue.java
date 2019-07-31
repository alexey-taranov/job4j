package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> stack = new SimpleStack<>();

    public void push(T value) {
        this.stack.push(value);
    }

    public T poll() {
        return this.stack.getSimpleStack().deleteFirstElement();
    }

    public DynamicLinkedList<T> getSimpleStack() {
        return stack.getSimpleStack();
    }
}
