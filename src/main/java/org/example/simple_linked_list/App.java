package org.example.simple_linked_list;

public class App {

    public static void main(String[] args) {
        SimpleLinkedList sll = new SimpleLinkedList();
        sll.insert(1);
        sll.insert(2);
        sll.insert(3);
        sll.insert(4);
        sll.insert(5);
        sll.insert(6);
        sll.insert(7);
        sll.insert(8);
        sll.insert(9);
        sll.insert(10);

        sll.print();
        sll.remove(1);
        sll.remove(10);
        sll.remove(5);
        sll.print();
    }
}
