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
