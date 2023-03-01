package org.example.doubly_linked_list;

public class Node {

    Node prev;
    Node next;
    int data;

    public Node(int data) {
        this.prev = null;
        this.next = null;
        this.data = data;
    }
}
