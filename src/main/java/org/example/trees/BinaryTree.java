package org.example.trees;

import org.example.queue.Queue;
import org.example.trees.model.Node;
import org.example.trees.model.TraversalType;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int data) {
        if (null == this.root) {
            this.root = new Node(data);
        }
        addRecursive(this.root, data);
    }

    private void addRecursive(Node node, int data) {
        if (data < node.data) {
            if (null == node.left) {
                node.left = new Node(data);
            } else {
                addRecursive(node.left, data);
            }
        } else if (data > node.data) {
            if (null == node.right) {
                node.right = new Node(data);
            } else {
                addRecursive(node.right, data);
            }
        }
    }

    public void invertTree() {
        if (null == this.root) {
            return;
        }
        Queue<Node> q = new Queue<>();
        q.add(this.root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            Node aux = node.left;
            node.left = node.right;
            node.right = aux;
            if (null != node.left) {
                q.add(node.left);
            }
            if (null != node.right) {
                q.add(node.right);
            }
        }
    }

    public void print(TraversalType traversalType) {
        if (null == traversalType) {
            throw new IllegalArgumentException("Traversal type must not be null");
        }
        switch (traversalType) {
            case POST_ORDER:
                postOrder(this.root);
                break;
            case IN_ORDER:
                inOrder(this.root);
                break;
            case PRE_ORDER:
                preOrder(this.root);
                break;
            default:
                throw new IllegalStateException("Invalid traversal option");
        }
        System.out.println("");
    }

    private void inOrder(Node node) {
        if (null == node) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}