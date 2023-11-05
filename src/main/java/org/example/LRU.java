package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LRU {

    private static final int DEFAULT_CAPACITY = 100;

    private final Map<Object, Node> refMap;
    private final int capacity;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.refMap = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public LRU() {
        this(DEFAULT_CAPACITY);
    }

    public Object get(Object obj) {
        if (refMap.containsKey(obj)) {
            this.put(obj);
            return refMap.get(obj);
        }
        return null;
    }

    public void put(Object obj) {
        if (refMap.containsKey(obj)) {
            Node refNode = refMap.remove(obj);
            if (refNode.prev != null) {
                refNode.prev.next = refNode.next;
                if (refNode.next == null) {
                    this.tail = refNode.prev;
                } else {
                    refNode.next.prev = refNode.prev;
                }
                refNode.next = this.head;
                refNode.prev = null;
                this.head = refNode;
            }
        } else {
            Node newNode = new Node(obj);
            if (this.capacity == refMap.size()) {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
                refMap.remove(this.tail.val);
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else {
                if (this.head == null) {
                    this.tail = newNode;
                } else {
                    newNode.next = this.head;
                    this.head.prev = newNode;
                }
                this.head = newNode;
            }
        }
        refMap.put(obj, this.head);
    }

    public void printList() {
        Node node = this.head;
        while (node != null) {
            log.info(" -> " + node.val);
            node = node.next;
        }
    }

    private static class Node {
        Object val;
        Node next;
        Node prev;

        public Node(Object val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}
