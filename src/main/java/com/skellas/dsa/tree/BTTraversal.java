package com.skellas.dsa.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTTraversal {

    public static void breadthFirst(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Deque<BinaryTreeNode> queue = new ArrayDeque();
        // add() is the same as addLast()
        queue.add(root);
        while (!queue.isEmpty()) {
            // remember to remove and not just "get"
            // remove() is the same as removeFirst()
            BinaryTreeNode node = queue.remove();
            System.out.println(node.toString());

            if (node.hasLeft())
                queue.add(node.getLeft());
            if (node.hasRight())
                queue.add(node.getRight());
        }
    }


    public static void depthFirst(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Deque<BinaryTreeNode> stack = new ArrayDeque();
        // push() is the same as addFirst()
        stack.push(root);
        while (!stack.isEmpty()) {
            // remember to remove and not just "get"
            // pop() is the same as removeFirst()
            BinaryTreeNode node = stack.pop();
            System.out.println(node.toString());

            if (node.hasLeft())
                stack.push(node.getLeft());
            if (node.hasRight())
                stack.push(node.getRight());
        }
    }


}
