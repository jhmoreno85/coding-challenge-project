package org.example.doubly_linked_list;

public class App {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addOrdered(2);
        dll.addOrdered(1);
        dll.addOrdered(10);
        dll.addOrdered(9);
        dll.addOrdered(5);
        dll.addOrdered(4);
        dll.addOrdered(8);
        dll.addOrdered(7);
        dll.addOrdered(3);
        dll.addOrdered(6);
        dll.addOrdered(0);
        dll.addOrdered(100);

        dll.print();
        dll.printReverse();
    }
}
