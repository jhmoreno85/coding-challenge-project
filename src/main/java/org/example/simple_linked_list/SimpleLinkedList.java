package org.example.simple_linked_list;

public class SimpleLinkedList {

    private Node head;

    public SimpleLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (null == this.head) {
            this.head = newNode;
        } else {
            Node curr = this.head;
            while (null != curr.next) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void remove(int data) {
        if (null != this.head) {
            if (this.head.data == data) {
                this.head = this.head.next;
            } else {
                Node curr = this.head;
                while(null != curr) {
                    if (null != curr.next && curr.next.data == data) {
                        curr.next = curr.next.next;
                        break;
                    }
                    curr = curr.next;
                }
            }
        }
    }

    public void print() {
        boolean flag = true;
        Node curr = this.head;
        while (null != curr) {
            if (flag) {
                System.out.print(curr.data);
                flag = false;
            } else {
                System.out.print(" -> " + curr.data);
            }
            curr = curr.next;
        }
        System.out.println();
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
