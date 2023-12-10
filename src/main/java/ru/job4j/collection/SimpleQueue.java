package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
            while (size != 0) {
                out.push(in.pop());
                size--;
            }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
