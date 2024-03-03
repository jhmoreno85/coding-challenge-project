package org.example.trees.model;

public class Node {

    public int data;
    public int depth;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }
}
