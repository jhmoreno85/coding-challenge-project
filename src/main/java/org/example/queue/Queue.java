package org.example.queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Queue {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private final int capacity;
    private int count;
    private Node head;
    private Node tail;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.count = ZERO;
        this.head = null;
        this.tail = null;
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public void add(int data) {
        if (isFull()) {
            throw new IllegalStateException("queue is full");
        }
        Node newNode = new Node(data);
        if (null == this.head) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.count++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        int data = this.head.data;
        if (ONE == this.count) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        this.count--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        return this.head.data;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return ZERO == this.count;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public void print() {
        Node aux = this.head;
        while (null != aux) {
            log.info("{}", aux.data);
            aux = aux.next;
        }
    }

    private static class Node {

        Node next;
        int data;

        public Node(int data) {
            this.next = null;
            this.data = data;
        }
    }
}
