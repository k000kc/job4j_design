package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleLinked<E> {
    private int size;
    private int modCount;
    private Node<E> head;
    private Node<E> last;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Node<E> rsl = head;
        Objects.checkIndex(index, size);
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current;
            private Node<E> next = head;
            private int expectedModCount = modCount;
            private int nextIndex;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = next;
                next = next.next;
                nextIndex++;
                return current.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}
