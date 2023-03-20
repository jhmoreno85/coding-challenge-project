package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LRU {

    private class Node {
        Object val;
        Node next;
        Node prev;

        public Node(Object val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private final int capacity;
    private final Map<Object, Node> refMap = new HashMap<>();
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
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

    public static void main(String[] args) {
        LRU app = new LRU(6);
        app.put(3);
        app.put(2);
        app.put(1);
        app.put(0);
        app.put(5);
        app.put(8);
        app.put(9);
        app.put(10);
        app.put(11);
        log.info("{}", app.get(9));
        log.info("{}", app.get(5));
        app.printList();
    }

    public void printList() {
        Node node = this.head;
        while (node != null) {
            log.info(" -> " + node.val);
            node = node.next;
        }
    }
}
