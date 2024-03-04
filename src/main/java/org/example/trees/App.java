package org.example.trees;

import org.example.trees.model.TraversalType;

public class App {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(5);
        bt.add(10);
        bt.add(4);
        bt.add(1);
        bt.add(7);
        bt.add(3);
        bt.add(12);
        bt.add(0);

        System.out.println("LCA [0, 3]: " + bt.getLCA(0, 3));
        System.out.println("LCA [7, 12]: " + bt.getLCA(7, 12));

        System.out.println("Min: " + bt.getMin());
        System.out.println("Max: " + bt.getMax());

        bt.traverse(TraversalType.IN_ORDER);
        bt.invertTree();
        bt.traverse(TraversalType.IN_ORDER);
    }
}
