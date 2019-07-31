package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> inStack = new SimpleStack<>();
    private SimpleStack<T> outStack = new SimpleStack<>();
    private int inSize = 0;
    private int outSize = 0;

    public void push(T value) {
        this.inStack.push(value);
        this.inSize++;
    }

    public T poll() {
        if (outSize == 0) {
            while (inSize != 0) {
                outStack.push(inStack.poll());
                inSize--;
                outSize++;
            }
        }
        outSize--;
        return outStack.poll();
    }
}
