package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class PrettyPrintTree {

    public static class Node {
        int level;
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.level = 0;
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(1);
        root.left.right = new Node(13);
        root.right.left = new Node(18);
        root.right.right = new Node(30);

        PrettyPrintTree app = new PrettyPrintTree();
        app.print(root);
    }

    public void print(Node n) {
        if (n == null) {
            return;
        }
        Queue<Node> curr = new LinkedList<>();
        Queue<Node> next = new LinkedList<>();
        curr.add(n);
        boolean isFirst = true;
        while (!curr.isEmpty()) {
            Node node = curr.poll();
            System.out.print(getPadding(3, node.level, isFirst, node.val));
            isFirst = false;
            if (node.left != null) {
                node.left.level = node.level + 1;
                next.add(node.left);
            }
            if (node.right != null) {
                node.right.level = node.level + 1;
                next.add(node.right);
            }
            if (curr.isEmpty()) {
                Queue<Node> aux = curr;
                curr = next;
                next = aux;
                isFirst = true;
                System.out.println("");
            }
        }
    }

    public String getPadding(int maxLevel, int level, boolean isFirst, int val) {
        int padding;
        if (isFirst) {
            padding = (int) (Math.pow(2, maxLevel - level) - 1);
        } else {
            padding = (int) (Math.pow(2, maxLevel - level + 1) - 1);
        }
        return " ".repeat(Math.max(0, padding)) + val;
    }
}
