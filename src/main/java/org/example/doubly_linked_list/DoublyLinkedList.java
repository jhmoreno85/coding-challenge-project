package org.example.doubly_linked_list;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (null == this.head) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
    }

    public void remove(int data) {
        Node aux = this.head;
        while (null != aux) {
            if (data == aux.data) {
                if (null == aux.prev && null == aux.next) {
                    this.head = null;
                    this.tail = null;
                } else if (null == aux.prev) {
                    this.head = aux.next;
                    this.head.prev = null;
                } else if (null == aux.next) {
                    this.tail = aux.prev;
                    this.tail.next = null;
                } else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                }
                break;
            }
            aux = aux.next;
        }
    }

    public void print() {
        boolean flag = true;
        Node aux = this.head;
        while (null != aux) {
            if (flag) {
                System.out.print("null <- " + aux.data);
                flag = false;
            } else {
                System.out.print(" <=> " + aux.data);
            }
            aux = aux.next;
        }
        System.out.print(" -> null");
    }
}
