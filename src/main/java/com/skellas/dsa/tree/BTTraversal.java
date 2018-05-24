package com.skellas.dsa.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTTraversal {

    /**
     * Iterate over each sibling before moving down into the
     * right/left sub trees. This is accomplished using a queue.
     * @param root
     */
    public static void breadthFirst(BinaryTreeNode root) {
        testNodeIsNotNull(root);
        // store all nodes in a queue
        Deque<BinaryTreeNode> queue = new ArrayDeque();
        // add() is the same as addLast()
        queue.add(root);
        while (!queue.isEmpty()) {
            // remember to remove and not just "get"
            // remove() is the same as removeFirst()
            BinaryTreeNode node = queue.remove();
            print(node);
            if (node.hasLeft())
                queue.add(node.getLeft());
            if (node.hasRight())
                queue.add(node.getRight());
        }
    }


    /**
     * Pre Ordered Depth First Traversal, using a simple loop.
     * This is accomplished via a stack.
     * @param root
     */
    public static void depthFirstWithLoop(BinaryTreeNode root) {
        testNodeIsNotNull(root);

        Deque<BinaryTreeNode> stack = new ArrayDeque();
        // push() is the same as addFirst()
        stack.push(root);
        while (!stack.isEmpty()) {
            // remember to remove and not just "get"
            // pop() is the same as removeFirst()
            BinaryTreeNode node = stack.pop();
            print(node);
            // this will end up adding right, then left
            // which means that we will traverse left first, always
            if (node.hasRight())
                stack.push(node.getRight());
            if (node.hasLeft())
                stack.push(node.getLeft());
        }
    }

    /**
     * Process node, then left, then right.
     * @param root
     */
    public static void depthFirstPreOrderWithRecursion(BinaryTreeNode root) {
        testNodeIsNotNull(root);
        // start with the root before traversing
        print(root);
        // then the left node
        if (root.hasLeft())
            depthFirstPreOrderWithRecursion(root.getLeft());
        // then the right node
        if (root.hasRight())
            depthFirstPreOrderWithRecursion(root.getRight());
    }

    /**
     * Process left, then node, then right
     * @param root
     */
    public static void depthFirstInOrderWithRecursion(BinaryTreeNode root) {
        testNodeIsNotNull(root);
        // start with the left node
        if (root.hasLeft())
            depthFirstInOrderWithRecursion(root.getLeft());
        // then the root node
        print(root);
        // then the right node
        if (root.hasRight())
            depthFirstInOrderWithRecursion(root.getRight());
    }

    public static void depthFirstPostOrderWithRecursion(BinaryTreeNode root) {
        testNodeIsNotNull(root);
        // start with the left node
        if (root.hasLeft())
            depthFirstPostOrderWithRecursion(root.getLeft());
        // then the right node
        if (root.hasRight())
            depthFirstPostOrderWithRecursion(root.getRight());
        // then the root node
        print(root);
    }

    /**
     * SUPER PRETTY FORMATTING
     * @param node
     */
    private static void print(BinaryTreeNode node) {
        System.out.println(node.toString());
    }

    /**
     * Welcome to the sledge hammer approach.
     * Don't do something like this in a real project...
     * @param node
     */
    private static void testNodeIsNotNull(BinaryTreeNode node) {
        if (null == node)
            throw new RuntimeException("Node Cannot Be Null");
    }

}
