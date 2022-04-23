package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class ReverseLinkedListInGroups {

    public Node head;

    public class Node {
        int data;
        Node next;

        Node( int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            log.info(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public void reverse(Node currIt, int k) {
        if (currIt == null) {
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>(k);
        Node aux = currIt;
        int count = 0;
        while (count < k && aux != null) {
            stack.push(aux.data);
            aux = aux.next;
            count++;
        }
        while (!stack.isEmpty()) {
            currIt.data = stack.pop();
            currIt = currIt.next;
        }
        reverse(aux, k);
    }

    public static void main(String[] args) {
        ReverseLinkedListInGroups list = new ReverseLinkedListInGroups();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        list.printList();

        list.reverse(list.head, 3);

        list.printList();
    }
}
