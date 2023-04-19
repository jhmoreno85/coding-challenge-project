package org.example.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Queue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    private int count;
    private Node<T> head;
    private Node<T> tail;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public void add(T data) {
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        }
        Node<T> newNode = new Node<>(data);
        if (null == this.head) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.count++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        T data = this.head.data;
        if (1 == size()) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.count--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return this.head.data;
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
        Node<T> aux = this.head;
        while (null != aux) {
            log.info("{}", aux.data);
            aux = aux.next;
        }
    }

    private static class Node<T> {

        Node<T> next;
        T data;

        public Node(T data) {
            this.next = null;
            this.data = data;
        }
    }
}
