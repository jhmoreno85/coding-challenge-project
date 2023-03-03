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

    public void addOrdered(int data) {
        Node newNode = new Node(data);
        if (null == this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if (newNode.data < this.head.data) {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            } else if (newNode.data > this.tail.data) {
                newNode.prev = this.tail;
                this.tail.next = newNode;
                this.tail = newNode;
            } else {
                Node curr = this.head;
                while (null != curr) {
                    if (newNode.data < curr.data) {
                        newNode.prev = curr.prev;
                        newNode.next = curr;
                        curr.prev.next = newNode;
                        curr.prev = newNode;
                        break;
                    }
                    curr = curr.next;
                }
            }
        }
    }

    public void remove(int data) {
        Node curr = this.head;
        while (null != curr) {
            if (data == curr.data) {
                if (null == curr.prev && null == curr.next) {
                    this.head = null;
                    this.tail = null;
                } else if (null == curr.prev) {
                    this.head = curr.next;
                    this.head.prev = null;
                } else if (null == curr.next) {
                    this.tail = curr.prev;
                    this.tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                break;
            }
            curr = curr.next;
        }
    }

    public void print(boolean reverseOrder) {
        boolean flag = true;
        Node curr = reverseOrder ? this.tail : this.head;
        while (null != curr) {
            if (flag) {
                System.out.print(curr.data);
                flag = false;
            } else {
                System.out.print(" -> " + curr.data);
            }
            curr = reverseOrder ? curr.prev : curr.next;
        }
        System.out.println("");
    }
}
