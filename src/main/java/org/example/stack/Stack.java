package org.example.stack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private int count;
    private Node<T> top;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.top = null;
    }

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public void push(T data) {
        if (isFull()) {
            throw new IllegalStateException("stack is full");
        }
        this.top = new Node<>(data, this.top);
        this.count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        T data = this.top.data;
        Node<T> aux = this.top;
        this.top = this.top.prev;
        aux.prev = null;
        this.count--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        return this.top.data;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    private boolean isFull() {
        return this.capacity == size();
    }

    public void print() {
        Node<T> aux = this.top;
        while (null != aux) {
            log.info("{}", aux.data);
            aux = aux.prev;
        }
    }

    private static class Node<T> {

        T data;
        Node<T> prev;

        public Node(T data, Node<T> node) {
            this.data = data;
            this.prev = node;
        }
    }
}
